### 如何开始一个Vaadin项目

由于之前一直使用的Eclipse，还没有正式的使用过IDEA玩过Vaadin。

所以就有一点点的卡壳了。 在官网上看到了这样一篇文章，介绍如何使用IDEA创建Vaadin，在最后链接处可查。

主要步骤分两步: 先创建一个项目，然后在项目中创建多个模块，每个模块就是一个个的Vaadin。 主要需要引入archetype：

    <groupId>com.vaadin</groupId>
    <artifictId>vaadin-archetype-application</artifictId>
    <!--目前公司使用版本-->
    <version>7.7.7</version>

然后就Oj8k了。    

### 参考文章

<a href="https://www.jetbrains.com/help/idea/getting-started-with-vaadin-maven-project.html"> Startup Vaadin project with IDEA.</a>