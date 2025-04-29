module co.edu.uniquindio.parcial2.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.parcial2 to javafx.fxml;
    exports co.edu.uniquindio.parcial2;
    opens co.edu.uniquindio.parcial2.viewcontroller;
    exports co.edu.uniquindio.parcial2.viewcontroller;
    opens co.edu.uniquindio.parcial2.controller;
    exports co.edu.uniquindio.parcial2.controller;

    opens co.edu.uniquindio.parcial2.model to javafx.base;
    exports co.edu.uniquindio.parcial2.EjemploFactoryMethod.viewContoller;
    opens co.edu.uniquindio.parcial2.EjemploFactoryMethod.viewContoller;
    exports co.edu.uniquindio.parcial2.EjemploFactoryMethod.Controller;
    opens co.edu.uniquindio.parcial2.EjemploFactoryMethod.Controller;
    opens co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model to javafx.base;

}