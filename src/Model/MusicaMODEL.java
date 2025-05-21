
package Model;

public class MusicaMODEL {
    private int id_musica;
    private String nome;
    private ArtistaMODEL artista;
    private String genero;
    
    // Construtor vazio, para não ficar preenchendo
    public MusicaMODEL() {
    }

    // Construtor para trazer os dados do banco
    public MusicaMODEL(int id_musica, String nome, ArtistaMODEL artista, String genero) {
        this.id_musica = id_musica;
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
    }

    public int getId_musica() {
        return id_musica;
    }

    public void setId_musica(int id_musica) {
        this.id_musica = id_musica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArtistaMODEL getArtista() {
        return artista;
    }

    public void setArtista(ArtistaMODEL artista) {
        this.artista = artista;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    
}
