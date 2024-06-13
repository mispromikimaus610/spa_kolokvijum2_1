package spa_kolokvijum2_1;

import labis.generator.StabloGenerator;

public class Test {

	public static void main(String[] args) {
		Binarno_stablo bs= new Binarno_stablo();
		StabloGenerator.izgenerisiStablo(bs);
		System.out.println(bs.proizvodListova(bs.koren));
		
		}

}
