
package Model;


public class UsuarioMODEL {
    private int id_usuario;
    private String nome;
    private String senha;

    public UsuarioMODEL(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public UsuarioMODEL(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuário{" + "nome=" + nome + ", senha=" + senha + "}";
    }
    
    
}
