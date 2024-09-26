package codeoJava;

import java.util.Objects;

import codeoJava.ejer17.Punto;

public class Vector3D {
    private Punto p;
    private float z;
    
    
    public Vector3D(float x, float y, float z) {
        this.p = new Punto(x,y);
        this.z = z;
    }


    public float getX() {
        return p.getX();
    }


    public void setX(float x) {
        p.setX(x);
    }


    public float getZ() {
        return z;
    }


    public void setZ(float z) {
        this.z = z;
    }

    public float getY(){
        return p.getY();
    }

    public void setY(float y) {
        this.p.setY(y);
    }

    public Vector3D sumaVector3d(Vector3D w){
        Punto suma = p.sumarPuntos(w.p);
        return new Vector3D(suma.getX(), suma.getY(), z + w.z);
    }

    @Override
    public String toString() {
        return "("+p.getX()+","+ p.getY()+","+ z +")";
    }

    @Override
    public boolean equals(Object otro) {
        
        if (this == otro) {
            return true;
        }
    
        if (otro == null || this.getClass() != otro.getClass()) {
            return false;
        }
    
        Vector3D otro2 = (Vector3D) otro;   // Downcasting a Vector3D

        return Objects.equals(this.p, otro2.p) && Objects.equals(this.getZ(), otro2.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(p,z);
    }
    

    
}
