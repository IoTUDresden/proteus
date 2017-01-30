package eu.vicci.process.graphiti;

import java.util.Vector;

public class ObjectTree<T> {

    T _object = null;
    ObjectTree<T> _parent = null;

    Vector<ObjectTree<T>> _children = null;

    public ObjectTree(T object) {

        _object = object;
    }

    public ObjectTree(ObjectTree<T> parent, T object) {

        _object = object;
        if (parent != null)
            parent.addChild(this);

        setParent(parent);
    }

    public void addChild(ObjectTree<T> child) {

        if (_children == null)
            _children = new Vector<ObjectTree<T>>();

        _children.add(child);
        child.setParent(this);
    }

    public void setParent(ObjectTree<T> p) {

        _parent = p;
    }

    public ObjectTree<T> getParent() {

        return _parent;
    }

    public Vector<ObjectTree<T>> getChildren() {

        return _children;
    }

    T getObject() {

        return _object;
    }
}
