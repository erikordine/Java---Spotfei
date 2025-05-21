
package Model;

public class ArtistaMODEL {
    private int id_artista;
    private String nome;

    // Construtor vazio, para não ficar preenchendo
    public ArtistaMODEL() {
    }

    // Construtor para trazer os dados do banco
    public ArtistaMODEL(int id_artista, String nome) {
        this.id_artista = id_artista;
        this.nome = nome;
    }
    
     // Construtor para cadastrar um novo artista
    public ArtistaMODEL(String nome) {
        this.nome = nome;
    }

    
    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
