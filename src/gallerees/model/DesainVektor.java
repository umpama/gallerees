package gallerees.model;

/**
 * Child class yang merepresentasikan aset berjenis Desain Vektor.
 * Menerapkan Polimorfisme melalui Override method getJenis() dan tampilkanDetail().
 */
public class DesainVektor extends AsetVisual {

    public DesainVektor() {
    }

    public DesainVektor(int id, String namaAset, String tema, String pathFile) {
        super(id, namaAset, tema, pathFile);
    }

    @Override
    public String getJenis() {
        return "Desain Vektor";
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("===== Detail Desain Vektor =====");
        System.out.println("ID        : " + getId());
        System.out.println("Nama Aset : " + getNamaAset());
        System.out.println("Tema      : " + getTema());
        System.out.println("Jenis     : " + getJenis());
        System.out.println("Path File : " + getPathFile());
        System.out.println("================================");
    }
}
