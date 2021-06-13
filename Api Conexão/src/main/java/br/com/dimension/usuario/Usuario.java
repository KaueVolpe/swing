package br.com.dimension.usuario;

public class Usuario {
        private String usuario;
        private String senha;
        private Integer idUsuario;
        private String nomeUsuario;

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public Integer getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }

        public void setNomeUsuario(String nomeUsuario) {
            this.nomeUsuario = nomeUsuario;
        }

        public Usuario() {
            this.usuario = usuario;
            this.senha = senha;
            this.idUsuario = idUsuario;
            this.nomeUsuario = nomeUsuario;
        }
    }



