package codeoJava;


public class TestVector3D {
    public static void main(String[] args) {
        float x1 = 1f;
        float y1 = 2f;
        float z1 = 3f;
        Vector3D v = new Vector3D(x1,y1,z1);

        float x2 = 0f;
        float y2 = 0f;
        float z2 = -1f;
        Vector3D w = new Vector3D(x2,y2,z2);

        System.out.println(v.toString());
        System.out.println(w.toString());
        

        Vector3D t = v.sumaVector3d(w);
        System.out.println(t.toString());
        
        Vector3D q = new Vector3D(1f,2f,2f);

        System.out.println(t.equals(q));

        System.out.println(t.hashCode());
        System.out.println(q.hashCode());
        

    }
}
