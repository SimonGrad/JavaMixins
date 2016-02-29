# Pure (CGlib) Java mixins
## Multiple class inheritance made easy

![uml](uml_what.png)

Did you had ever the problem having a growing interface which implementation class is getting larger and larger? 
I had it in many of my projects and one solution which does not require complicated patterns is using [mixins](https://en.wikipedia.org/wiki/Mixin).
They are implemented in Java as an easy to use proxy which can mix virtual class from single instances into new 
instances. Other programming languages do support them natively, but Java does not. Thus it requires an extension 
library. [CGlib](https://github.com/cglib/cglib) is quite often used for several aspects of class manipulation and it has already a very 
easy to use [mixin proxy](http://cglib.sourceforge.net/apidocs/net/sf/cglib/proxy/Mixin.html) implementation.

You have to refactor your original interface this way: 

1. Split your original interface into several single interfaces (InterfaceOne, InterfaceTwo, ...)
2. Create an implementation for each single interface (ClassOne, ClassTwo, ...)
3. Empty original interface end let it extends all single interfaces from point (2) (InterfaceBoth)
4. Create a mixin proxy like shown in this example. (InterfaceBoth iBoth = (InterfaceBoth) Mixin.create(...))

Additionally this example is showing how to do this in a spring environment and how to inject resources. The main 
challenge was to configure the implementation classes from spring. As they are configured outside of spring. To solve 
this, I have created a factory which is running inside spring scope and to give this factory all needed references.

Any comments and alternatives are welcome !