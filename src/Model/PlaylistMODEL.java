
package Model;

public class PlaylistMODEL {
    private int id_playlist;
    private String nome;
    private UsuarioMODEL usuario;
    
    public PlaylistMODEL() {}

    // Construtor para fazer a busca por id
    public PlaylistMODEL(int id_playlist, String nome, UsuarioMODEL usuario) {
        this.id_playlist = id_playlist;
        this.nome = nome;
        this.usuario = usuario;
    }

    // Construtor para criar uma nova playlist
    public PlaylistMODEL(String nome, UsuarioMODEL usuario) {
        this.nome = nome;
        this.usuario = usuario;
    }

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioMODEL getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioMODEL usuario) {
        this.usuario = usuario;
    }
    
    
}
