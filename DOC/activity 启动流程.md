* **Activity**.startActivity ->
* **Instrumentation**.execStartActivity ->
* **Binder** -> 
* **AMS**.startActivity ->
* **ActivityStarter**.
    * startActivityMayWait ->
    * startActivityLocked ->
    * startActivityUnChecked

* **ActivityStackSupervisor**.resumeFocusedStackTopActivityLocked ->
* **ActivityStack**
    * resumeTopActivityUncheckLocked 
    * resumeTopActivityInnerLocked 
* **ActivityStackSupervisor**
   * startSpecificActivityLocked 
   * realStartActivityLocked -> 
* **Binder** ->
* **ApplicationThread**.scheduleLaunchActivity -> H ->
* **ActivityThread**.scheduleLaunchActivity ->
  * handleLaunchActivity ->
  * performLaunchActivity ->
* **Instrumentation**.newActivity
* Activity -> callActivityOnCreate 一系列生命周期