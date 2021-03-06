package com.marakana.android.fibonacciclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ServiceConnection {


    private static final String TAG = "FibonacciActivity";

    private EditText input; // our input n

    private Button button; // trigger for fibonacci calcualtion

    private RadioGroup type; // fibonacci implementation type

    private TextView output; // destination for fibonacci result

    private IFibonaccixService service; // reference to our service

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        // connect to our UI elements
        this.input = (EditText) super.findViewById(R.id.input);
        this.button = (Button) super.findViewById(R.id.button);
        this.type = (RadioGroup) super.findViewById(R.id.type);
        this.output = (TextView) super.findViewById(R.id.output);
        // request button click call-backs via onClick(View) method
        this.button.setOnClickListener(this);
        // the button will be enabled once we connect to the service
        this.button.setEnabled(false);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()'ed");
        super.onResume();
        // Bind to our FibonacciService service, by looking it up by its name
        // and passing ourselves as the ServiceConnection object
        // We'll get the actual IFibonacciService via a callback to
        // onServiceConnected() below
        if (!super.bindService(new Intent(IFibonacciService.class.getName()),
                this, BIND_AUTO_CREATE)) {
            Log.w(TAG, "Failed to bind to service");
        }
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()'ed");
        super.onPause();
        // No need to keep the service bound (and alive) any longer than
        // necessary
        super.unbindService(this);
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "onServiceConnected()'ed to " + name);
        // finally we can get to our IFibonacciService
        this.service = IFibonacciService.Stub.asInterface(service);
        // enable the button, because the IFibonacciService is initialized
        this.button.setEnabled(true);
    }

    public void onServiceDisconnected(ComponentName name) {
        Log.d(TAG, "onServiceDisconnected()'ed to " + name);
        // our IFibonacciService service is no longer connected
        this.service = null;
        // disabled the button, since we cannot use IFibonacciService
        this.button.setEnabled(false);
    }

    // handle button clicks
    public void onClick(View view) {
        // parse n from input (or report errors)
        final long n;
        String s = this.input.getText().toString();
        if (TextUtils.isEmpty(s)) {
            return;
        }
        try {
            n = Long.parseLong(s);
        } catch (NumberFormatException e) {
            this.input.setError(super.getText(R.string.input_error));
            return;
        }

        // build the request object
        final FibonacciRequest.Type type;
        switch (FibonacciActivity.this.type.getCheckedRadioButtonId()) {
            case R.id.type_fib_jr:
                type = FibonacciRequest.Type.RECURSIVE_JAVA;
                break;
            case R.id.type_fib_ji:
                type = FibonacciRequest.Type.ITERATIVE_JAVA;
                break;
            case R.id.type_fib_nr:
                type = FibonacciRequest.Type.RECURSIVE_NATIVE;
                break;
            case R.id.type_fib_ni:
                type = FibonacciRequest.Type.ITERATIVE_NATIVE;
                break;
            default:
                return;
        }
        final FibonacciRequest request = new FibonacciRequest(n, type);

        // showing the user that the calculation is in progress
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                super.getText(R.string.progress_text), true);
        // since the calculation can take a long time, we do it in a separate
        // thread to avoid blocking the UI
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                // this method runs in a background thread
                try {
                    long totalTime = SystemClock.uptimeMillis();
                    FibonacciResponse response = FibonacciActivity.this.service
                            .fib(request);
                    totalTime = SystemClock.uptimeMillis() - totalTime;
                    // generate the result
                    return String.format(
                            "fibonacci(%d)=%d\nin %d ms\n(+ %d ms)", n,
                            response.getResult(), response.getTimeInMillis(),
                            totalTime - response.getTimeInMillis());
                } catch (RemoteException e) {
                    Log.wtf(TAG, "Failed to communicate with the service", e);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                // get rid of the dialog
                dialog.dismiss();
                if (result == null) {
                    // handle error
                    Toast.makeText(FibonacciActivity.this, R.string.fib_error,
                            Toast.LENGTH_SHORT).show();
                } else {
                    // show the result to the user
                    FibonacciActivity.this.output.setText(result);
                }
            }
        }.execute(); // run our AsyncTask
    }
}