    在JDK5.0之后，Java提供了更加健壮的线程处理机制，包括同步、锁定、线程池等，它们可以实现更细粒度的线程控制。await()和signal()就是其中用来做同步的两种方法，
它们的功能基本上和wait() / nofity()相同，完全可以取代它们，但是它们和新引入的锁定机制Lock直接挂钩，具有更大的灵活性。通过在Lock对象上调用newCondition()方法，
将条件变量和一个锁对象进行绑定，进而控制并发程序访问竞争资源的安全。