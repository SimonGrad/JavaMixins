# Pure (CGlib) Java mixins
## Multiple class inheritance in Java made easy

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

# License for the examples

The MIT License (MIT)

Copyright (c) 2016 Adam Jones

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
