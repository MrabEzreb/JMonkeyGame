package com.ezrebclan.jme;

import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 * 
 * @author MrabEzreb
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    Node boxNode;
    @Override
    public void simpleInitApp() {
        boxNode = new Node("boxNode");
        Box b = new Box(1, 1, 1);
        Geometry geometry = new Geometry("MyBox", b);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        geometry.setMaterial(mat);
        boxNode.attachChild(geometry);
        Box ourBox = new Box(1, 1, 1);
        Geometry geoForBox = new Geometry("Our box", ourBox);
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Pink);
        geoForBox.setMaterial(mat2);
        geoForBox.setLocalTranslation(4, 1, 1);
        geoForBox.rotate(10, 45, 2);
        boxNode.attachChild(geoForBox);
        boxNode.rotate(10, 45, 2);
        rootNode.attachChild(boxNode);
    }

    private void initKeys() {
        inputManager.addMapping("Pause", new KeyTrigger(keyInput.KEY_P));
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        boxNode.rotate(1.2f*tpf, 1.2f*tpf, 1.2f*tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
