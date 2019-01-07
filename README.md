# ModularsArchitectureDemo

##About Project
Project which be designed for Multi-module,in this Project we will tell us how to pass `Application lifecyle` to children module and use `ARouter` Framework to implement page change in the different mode.

##How to compile
whether build single module is depending on the module `buildSrc/dependencies.kt` files,which contains `isBuildModuleOnly` variable,when it is true,we will build Multi-module project,otherwise we can build every module as a independence apps,every time when we change values of  `isBuildModuleOnly` ,we need to reload project from Android Studio.

