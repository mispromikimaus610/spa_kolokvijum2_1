import labis.generator.StabloGenerator;

public class Test {

	public static void main(String[] args) {
		
		BinarnoStablo bs = new BinarnoStablo();
		StabloGenerator.izgenerisiStablo(bs);
		bs.postaviBroj(bs.koren, 3);
		
		
	}

}
