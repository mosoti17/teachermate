package ml.elvismogaka.teachermate.models;

/**
 * Created by mosoti on 12/20/17.
 */

public class Class {
    int id;
    String name,classteacher;

    public Class(int id, String name, String classteacher) {
        this.id = id;
        this.name = name;
        this.classteacher = classteacher;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassteacher() {
        return classteacher;
    }
}
