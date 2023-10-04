package db;

public class DbException extends RuntimeException {//execessão personalizada para acesso a dados com 
	//implementação básica para acesso a dados.

	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg);//construtor criado para envio de mensagem. 
	}

}
