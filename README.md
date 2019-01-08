# ModularsArchitectureDemo

## About Project

Project which be designed for Multi-module,in this Project we will tell us how to pass `Application lifecyle` to children module and use `ARouter` Framework to implement page change in the different mode.

## How to compile

whether build single module is depending on the module `buildSrc/dependencies.kt` files,which contains `isBuildModuleOnly` variable,when it is true,we will build Multi-module project,otherwise we can build every module as a independence apps,every time when we change values of  `isBuildModuleOnly` ,we need to reload project from Android Studio.

## How to add new module in project

- according to Android Studio new module introduce, add new module to project.and then according to compile options to make modules compile as an app or library.
- add a new Activity to module that created in the first step,and declare activity in the manifest files.
- create a new class which implements ApplicationLifecycleDelegate interface and declare this class as a meta-data tag in the manifest files.
- make app modules to implements modules that we created in the first step.
- init ARouter framework in the class which implements ApplicationLifecycleDelegate interface,and declare ARouter path in the activity of that created modules in the first step.
- call ARouter path navigation methos in the app modules when we want to go activity page that we created in the created modules ,at last ,compile and run project.


## License
`Copyright 2012 Square, Inc.`

`Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at`

   `http://www.apache.org/licenses/LICENSE-2.0`

`Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License`
