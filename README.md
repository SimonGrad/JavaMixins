# Pure (CGlib) Java mixins
## Multiple class inheritance made easy

![uml](uml_what.png)

Did you had ever the problem having a growing interface which implementation 
class is getting larger and larger? I had it in many of my projects and one 
solution which does not require complicated patterns is using mixins. They are 
easy to use proxy which can mix virtual class from single instances into new
instances.

You have to refactor your original interface this way: 

1. Split your OriginalInterface into several single interfaces (InterfaceOne, InterfaceTwo, ...)
2. Create an implementation for each single interface (ClassOne, ClassTwo, ...)
3. Empty OriginalInterface end let it extends all single interfaces from point (2) (InterfaceBoth)
4. Create a Mixin Proxy like shown in this example. (InterfaceBoth iBoth = (InterfaceBoth) Mixin.create(...))

Additionally this example is showing how to do this in a spring environment if you need to inject resources. 
The main advantage was to configure the implementation classes from spring. As they are configured outside
of spring. To solve this, I have created a factory which is running inside spring scope and give
this factory all needed references.

Mixin helper used: http://cglib.sourceforge.net/apidocs/net/sf/cglib/proxy/Mixin.html

Any comments and alternatives are welcome !