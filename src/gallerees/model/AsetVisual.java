package gallerees.model;

/**
 * Abstract class yang menjadi induk dari semua jenis aset visual.
 * Menerapkan Enkapsulasi penuh (private attributes + getter/setter).
 */
public abstract class AsetVisual implements Manageable {

    private int id;
    private String namaAset;
    private String tema;
    private String pathFile;

    // ──────────────────────── Constructor ────────────────────────

    public AsetVisual() {
    }

    public AsetVisual(int id, String namaAset, String tema, String pathFile) {
        this.id       = id;
        this.namaAset = namaAset;
        this.tema     = tema;
        this.pathFile = pathFile;
    }

    // ──────────────────────── Abstract Method ───────────────────

    /**
     * Mengembalikan jenis aset secara spesifik.
     * Diimplementasikan oleh setiap child class.
     */
    public abstract String getJenis();

    // ──────────────────────── Getter & Setter ───────────────────

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaAset() {
        return namaAset;
    }

    public void setNamaAset(String namaAset) {
        this.namaAset = namaAset;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
