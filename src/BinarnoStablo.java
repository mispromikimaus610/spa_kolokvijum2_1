import labis.cvorovi.CvorStabla;
import labis.stabla.ABinarnoStablo;

public class BinarnoStablo extends ABinarnoStablo {

	public void infiks(CvorStabla koren) {
		if (koren == null)
			return;
		infiks(koren.levo);
		System.out.println(koren.podatak + " ");
		infiks(koren.desno);
	}

	public void postaviBroj(CvorStabla koren, int broj) {
		if (koren == null)
			return;
		koren.podatak = broj;
		postaviBroj(koren.levo, broj);
		postaviBroj(koren.desno, broj);
	}

	public int brojElemenata(CvorStabla koren) {
		if (koren == null)
			return 0;
		return 1 + brojElemenata(koren.levo) + brojElemenata(koren.desno);
	}

	public int zbirElemenata(CvorStabla koren) {
		if (koren == null)
			return 0;
		return koren.podatak + zbirElemenata(koren.levo) + zbirElemenata(koren.desno);
	}

	public double prosekElemenata(CvorStabla koren) {
		return zbirElemenata(koren) / brojElemenata(koren);
	}

	public boolean cvoroviPet(CvorStabla koren) {

		if (koren == null)
			return true;
		return (koren.podatak == 5 && cvoroviPet(koren.desno) && cvoroviPet(koren.levo));
	}

	public int proizvodNeparnih(CvorStabla koren) {
		if (koren == null)
			return 1;
		if (koren.podatak % 2 == 1)
			return koren.podatak * proizvodNeparnih(koren.desno) * proizvodNeparnih(koren.levo);
		else
			return proizvodNeparnih(koren.levo) * proizvodNeparnih(koren.desno);
	}

	public int imajuLevo(CvorStabla koren) {
		if (koren == null)
			return 0;
		if (koren.levo != null)
			return 1 + imajuLevo(koren.levo) + imajuLevo(koren.desno);
		else
			return imajuLevo(koren.levo) + imajuLevo(koren.desno);
	}

	public boolean postoji(CvorStabla koren, CvorStabla zadati) {
		if (koren == null)
			return false;
		if (koren == zadati)
			return true;
		else
			return postoji(koren.desno, zadati) || postoji(koren.levo, zadati);

	}

	public int uIntervalu(CvorStabla koren, int dg, int gg) {
		if (koren == null)
			return 0;
		if (koren.podatak > dg && koren.podatak < gg)
			return 1 + uIntervalu(koren.levo, dg, gg) + uIntervalu(koren.desno, dg, gg);
		else
			return uIntervalu(koren.levo, dg, gg) + uIntervalu(koren.desno, dg, gg);
	}

	public int neparniListovi(CvorStabla koren) {
		if (koren == null)
			return 0;
		if (koren.levo == null && koren.desno == null && koren.podatak % 2 == 1)
			return 1 + neparniListovi(koren.levo) + neparniListovi(koren.desno);
		else
			return neparniListovi(koren.levo) + neparniListovi(koren.desno);
	}

	public int jednocifreniPolulistovi(CvorStabla koren) {
		if (koren == null)
			return 0;
		if ((koren.levo == null) != (koren.desno == null) && koren.podatak < 10)
			return koren.podatak + jednocifreniPolulistovi(koren.desno) + jednocifreniPolulistovi(koren.levo);
		else
			return jednocifreniPolulistovi(koren.desno) + jednocifreniPolulistovi(koren.levo);
	}

	public int proizvodUnutrasnjih(CvorStabla koren) {
		if (koren == null)
			return 1;
		if ((koren.levo != null && koren.desno != null) && (koren.podatak > koren.levo.podatak + koren.desno.podatak))
			return koren.podatak * proizvodUnutrasnjih(koren.desno) * proizvodUnutrasnjih(koren.levo);
		else
			return proizvodUnutrasnjih(koren.desno) * proizvodUnutrasnjih(koren.levo);
	}

	public int nemajuVeceDete(CvorStabla koren) {
		if (koren == null || koren.levo == null || koren.desno == null)
			return 0;
		if (koren.levo.podatak <= koren.podatak && koren.desno.podatak <= koren.podatak)
			return 1 + nemajuVeceDete(koren.desno) + nemajuVeceDete(koren.levo);
		else
			return proizvodUnutrasnjih(koren.desno) * proizvodUnutrasnjih(koren.levo);
	}

	public int najveciElement(CvorStabla koren) {
		if (koren == null)
			return Integer.MIN_VALUE;
		return Math.max(koren.podatak, Math.max(najveciElement(koren.desno), najveciElement(koren.levo)));
	}

	public int visina(CvorStabla koren) {
		if (koren == null)
			return 0;
		if(koren.levo == null && koren.desno == null) {
			return 1;
		}
		return 1 + Math.max(visina(koren.desno), visina(koren.levo));
	}
	
	public CvorStabla najdubljiCvor(CvorStabla koren) {
		if(koren == null)
			return null;
		if(koren.desno == null && koren.levo == null)
			return koren;
		if(visina(koren.desno) > visina(koren.levo))
			return najdubljiCvor(koren.desno);
		else
			return najdubljiCvor(koren.levo);
	}

}
