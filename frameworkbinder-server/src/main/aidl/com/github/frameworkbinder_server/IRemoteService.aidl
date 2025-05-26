// IRemoteService.aidl
package com.github.frameworkbinder_server;
import com.github.frameworkbinder_server.MyProcess;



interface IRemoteService {
 int getPid();

 MyProcess getProcess(in MyProcess clientProcess);

}