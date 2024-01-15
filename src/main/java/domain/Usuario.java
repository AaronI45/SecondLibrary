package domain;

public class Usuario {
    public static final int ADMINISTRADOR = 1;
    public static final int COMERCIANTE= 2;

    public static final int NO_APROBADO = 1;
    public static final int APROBADO = 2;
    public static final int BLOQUEADO = 3;

    private int idUsuario;
    private int idEstadoUsuario;
    private int idRol;
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;
    private String correo;
    private String tokenLogin;
    public Usuario(){}

    public Usuario(int idUsuario, int idEstadoUsuario, int idRol, String nombreUsuario, String contrasena, String nombre, String apellidoPaterno, String apellidoMaterno, String matricula, String correo, String tokenLogin) {
        this.idUsuario = idUsuario;
        this.idEstadoUsuario = idEstadoUsuario;
        this.idRol = idRol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.correo = correo;
        this.tokenLogin = tokenLogin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTokenLogin() {
        return tokenLogin;
    }

    public void setTokenLogin(String tokenLogin) {
        this.tokenLogin = tokenLogin;
    }
}
