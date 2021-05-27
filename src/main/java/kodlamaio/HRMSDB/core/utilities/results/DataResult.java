package kodlamaio.HRMSDB.core.utilities.results;

//birden fazla veri tipi varsa t yazıyoruz
public class DataResult<T> extends Result{

	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message); //süper:base sınıfın consrtactırları çalıştırıyor
		this.data = data;
	}
	
	public DataResult(T data, boolean success) {
		super(success); //süper:base sınıfın consrtactırları çalıştırıyor
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
	

}
