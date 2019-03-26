package modelo;
// Generated 26/03/2019 03:59:19 PM by Hibernate Tools 4.3.1



/**
 * CalificaId generated by hbm2java
 */
public class CalificaId  implements java.io.Serializable {


     private int marcador;
     private int comentario;

    public CalificaId() {
    }

    public CalificaId(int marcador, int comentario) {
       this.marcador = marcador;
       this.comentario = comentario;
    }
   
    public int getMarcador() {
        return this.marcador;
    }
    
    public void setMarcador(int marcador) {
        this.marcador = marcador;
    }
    public int getComentario() {
        return this.comentario;
    }
    
    public void setComentario(int comentario) {
        this.comentario = comentario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CalificaId) ) return false;
		 CalificaId castOther = ( CalificaId ) other; 
         
		 return (this.getMarcador()==castOther.getMarcador())
 && (this.getComentario()==castOther.getComentario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMarcador();
         result = 37 * result + this.getComentario();
         return result;
   }   


}

