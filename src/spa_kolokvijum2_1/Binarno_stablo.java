package spa_kolokvijum2_1;


import labis.cvorovi.CvorStabla;
import labis.exception.LabisException;
import labis.stabla.ABinarnoStablo;

public class Binarno_stablo extends ABinarnoStablo{

		public void infiks(CvorStabla koren) {
			if(koren==null)
				return;
			infiks(koren.levo);
			System.out.println(koren.podatak + " ");
			infiks(koren.desno);
		}
		
		public int brojElemenataStabla(CvorStabla koren) {
			if(koren==null)
				return 0;
			return 1 + brojElemenataStabla(koren.levo) + brojElemenataStabla(koren.desno);
			
		}
		
		public int zbir(CvorStabla koren) {
			if(koren==null)
				return 0;
			return koren.podatak + zbir(koren.levo) + zbir(koren.desno);
			}
		
		public int brojElemenata(CvorStabla koren) {
			if(koren==null)
				return 0;
			return 1 + brojElemenata(koren.levo) + brojElemenata(koren.desno);
			
		}
		
		public double prosek(CvorStabla koren) throws LabisException {
			if(koren==null) {
				throw new LabisException("Prazno stablo");
			}
			return (double) zbir(koren)/brojElemenata(koren);
		}

		public boolean sviCvorovi5(CvorStabla koren) {
			if(koren==null)
				return true;
			return (koren.podatak==5 && sviCvorovi5(koren.levo) && sviCvorovi5(koren.desno) );
		}

		public int proizvodNeparnih(CvorStabla koren) {
			if(koren==null)
				return 1;
			if(koren.podatak%2==1)
				return koren.podatak * proizvodNeparnih(koren.levo) * proizvodNeparnih(koren.desno);
			return 1*proizvodNeparnih(koren.levo) * proizvodNeparnih(koren.desno);
		}

		public int brojCvorovaLevo(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(koren.levo!=null) {
				return 1+brojCvorovaLevo(koren.levo) + brojCvorovaLevo(koren.desno);
			}
			return brojCvorovaLevo(koren.desno);
		}
		
		public boolean PostojiCvor(CvorStabla koren, CvorStabla cvor) {
			if(koren==null)
				return false;
			if(koren==cvor)
				return true;
			return PostojiCvor(koren.levo, cvor) || PostojiCvor(koren.desno, cvor);
		}
		
		public int brojInterval(CvorStabla koren, int dg, int gg) {
			if(koren==null)
				return 0;
			if(koren.podatak> dg && koren.podatak < gg) {
				return 1 + brojInterval(koren.levo, dg, gg) + brojInterval(koren.desno, dg, gg);
			}
			return brojInterval(koren.levo, dg, gg) + brojInterval(koren.desno, dg, gg);
		}
		
		public int neparniListovi(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(koren.levo==null && koren.desno==null && koren.podatak%2==1) {
				return 1;
			}
			return neparniListovi(koren.levo) + neparniListovi(koren.desno);
		}

		public int zbirNeparnih(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(((koren.levo==null) != (koren.desno==null)) && koren.podatak<10) {
				return koren.podatak+zbirNeparnih(koren.levo) + zbirNeparnih(koren.desno);
			}
			return zbirNeparnih(koren.levo)+zbirNeparnih(koren.desno);
		}
		
		public int proizvodVelikih(CvorStabla koren) {
			if(koren==null)
				return 1;
			if(koren.levo != null && koren.desno !=null && koren.podatak>(koren.levo.podatak + koren.desno.podatak)) {
				return koren.podatak * proizvodVelikih(koren.levo) * proizvodVelikih(koren.desno);
			}
			return proizvodVelikih(koren.levo) * proizvodVelikih(koren.desno);		
			}
		
		public int maladeca(CvorStabla koren) {
			if(koren==null || koren.levo==null || koren.desno==null)
				return 0;
			if(koren.levo.podatak < koren.podatak && koren.desno.podatak < koren.podatak) {
				return 1 + maladeca(koren.levo) + maladeca(koren.desno);
			}
			return maladeca(koren.levo)+maladeca(koren.desno);
			
		}

		public int max(CvorStabla koren) {
			if(koren==null) 
				return Integer.MIN_VALUE;
			return Math.max(koren.podatak, Math.max(max(koren.levo), max(koren.desno)));
		}
		
		public int visina(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(koren.levo==null && koren.desno==null)
				return 1;
			return 1 + Math.max(visina(koren.levo),visina(koren.desno));
		}
		
		public CvorStabla najdublji(CvorStabla koren) {
			if(koren==null)
				return null;
			if(koren.levo==null && koren.desno==null)
				return koren;
			if(visina(koren.levo)>visina(koren.desno))
				return koren.levo;
			return koren.desno;
		}

		public int listProizvod(CvorStabla koren) {
			if(koren==null)
				return 1;
			if(koren.levo==null && koren.desno==null)
				return koren.podatak;
			return listProizvod(koren.levo) * listProizvod(koren.desno);
		}

		public int negativ(CvorStabla koren) {
			if(koren==null)
				return 0;
			return negativ(koren.levo) + negativ(koren.desno) + koren.podatak;
			
		}

		public int binarnobroj(CvorStabla koren) {
			if(koren==null) {
				return 0;
			}
			if(koren.levo.podatak>koren.desno.podatak) {
				return 1 + binarnobroj(koren.levo) + binarnobroj(koren.desno);
			}
			return binarnobroj(koren.levo) + binarnobroj(koren.desno);
		}
		
		public int binarnozbir(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(koren.levo.podatak>koren.desno.podatak)
				return koren.podatak+ binarnozbir(koren.levo) + binarnozbir(koren.desno);
			return binarnozbir(koren.levo) + binarnozbir(koren.desno);
		}
		
		public int binarno(CvorStabla koren) {
			if(koren==null)
				return 0;
			return binarnozbir(koren)/binarnobroj(koren);
		}
		
		public int parniroditelji(CvorStabla koren) {
			if(koren==null)
				return 0;
			if((koren.levo != null || koren.desno != null) && koren.podatak%2==0) {
				return 1+parniroditelji(koren.levo) + parniroditelji(koren.desno);
			}
			return parniroditelji(koren.levo) + parniroditelji(koren.desno);
		}
		
		
		
		public int parametar(CvorStabla koren) {
			if(koren==null || koren.levo==null || koren.desno==null)
				return 0;
			if(koren.levo.podatak%2==1 && koren.desno.podatak%2==0 )
				return 1+parametar(koren.levo) + parametar(koren.desno);
			return parametar(koren.levo) + parametar(koren.desno);
		}
		
		public int proizvodListova(CvorStabla koren) {
			if(koren==null)
				return 1;
			if(koren.levo==null && koren.desno==null) {
				return koren.podatak;
			}
			return proizvodListova(koren.levo) * proizvodListova(koren.desno);
		}
		
		public int zbirNajdubljih(CvorStabla koren) throws LabisException {
			if(koren==null) {
				throw new LabisException("Greska");
			}
			int Najdublji=visina(koren);
			return zbirnanajdubljem(koren, 1, Najdublji);
		}
		public int zbirnanajdubljem(CvorStabla koren, int nivo, int najdublji) {
			if(koren==null)
				return 0;
			if(koren.levo==null && koren.desno==null && nivo==najdublji) {
				return koren.podatak;
			}
			return zbirnanajdubljem(koren.levo,nivo + 1, najdublji) + zbirnanajdubljem(koren.desno,1 + nivo, najdublji);
		}
		
		public int proizvodPredaka(CvorStabla koren, CvorStabla cvor1, CvorStabla cvor2) throws LabisException {
			if(koren==null) {
				throw new LabisException("Greska 1");
			}
			if(pzp(koren,cvor1,cvor2)==1)
				throw new LabisException("Greska 2");
			if(!PostojiCvor(koren, cvor1) || !PostojiCvor(koren, cvor2))
				throw new LabisException("GRESKA 3");
			
			
			return pzp(koren,cvor1,cvor2);
		}
		
		public int pzp(CvorStabla koren, CvorStabla cvor1, CvorStabla cvor2) {
			if(koren==null)
				return 1;
			if((PostojiCvor(koren.levo,cvor1) || PostojiCvor(koren.desno, cvor1)) 
					&& (PostojiCvor(koren.desno, cvor2) || PostojiCvor(koren.desno, cvor2)))
				return koren.podatak * pzp(koren.levo, cvor1, cvor2) * pzp(koren.desno,cvor1,cvor2);
			return pzp(koren.levo,cvor1,cvor2) * pzp(koren.desno,cvor1,cvor2);
			
		}
		
		public int najvecizbir(CvorStabla koren) throws LabisException {
			if(koren==null)
				throw new LabisException("Greska0");
			return v_najvecizbir(koren);
		}
		public int v_najvecizbir(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(koren.desno==null)
				return koren.podatak + v_najvecizbir(koren.levo);
			if(koren.levo==null)
				return koren.podatak + v_najvecizbir(koren.desno);
			return koren.podatak + Math.max(v_najvecizbir(koren.levo), v_najvecizbir(koren.desno));
		}
		
		public int najvecarazlika(CvorStabla koren) throws LabisException{
			if(koren==null)
				throw new LabisException("GRESKA");
			if(koren.levo==null && koren.desno==null)
				throw new LabisException("GRESKA 2");
			return v_najvecarazlika(koren);
		}
		
		public int v_najvecarazlika(CvorStabla koren) {
			if(koren==null)
				return Integer.MIN_VALUE;
			int razlikalevo=Integer.MIN_VALUE;
			int razlikadesno=Integer.MIN_VALUE;
			if(koren.levo!=null) {
				razlikalevo=Math.abs(koren.podatak - koren.levo.podatak);
			}
			if(koren.desno!=null) {
				razlikadesno=Math.abs(koren.podatak - koren.desno.podatak);
			}
			return Math.max(Math.max(razlikalevo, razlikadesno), 
					Math.max(v_najvecarazlika(koren.levo), v_najvecarazlika(koren.desno)));
		}
		
		public int brojSaVecim(CvorStabla koren, int i) {
			if(koren==null)
				return 0;
			if(zbir(koren) > i) {
				return 1 + brojSaVecim(koren.levo, i) + brojSaVecim(koren.desno, i);
			}	
			return	0;
		}
		
		public int ZNN(CvorStabla koren, int nivo, int broj) {
			if(koren==null)
				return 0;
			if(nivo==broj && koren.levo!=null && koren.desno!=null) {
				return koren.podatak;
			}
			return ZNN(koren.levo, 1 + nivo, broj) + ZNN (koren.desno, 1 + nivo,broj);
		}
		
		public int ZbirZbirova(CvorStabla koren) {
			if(koren==null)
				return 0;
			return Math.max(Math.max(zbir(koren), Math.max(zbir(koren.levo), zbir(koren.desno))), 
					Math.max(ZbirZbirova(koren.levo), ZbirZbirova(koren.desno)));
		}
		
		public int dubljePodstablo(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(visina(koren.levo)>visina(koren.desno))
				return 1+dubljePodstablo(koren.levo) + dubljePodstablo(koren.desno);
			return dubljePodstablo(koren.levo) + dubljePodstablo(koren.desno);
		}
		
		public int parniRoditelji(CvorStabla koren) {
			if(koren==null)
				return 0;
			if(koren.levo!=null && koren.desno!=null && koren.podatak%2==0) {
				return 2 + parniRoditelji(koren.levo) + parniRoditelji(koren.desno);
			}
			else if(koren.levo==null && koren.desno==null && koren.podatak%2==0)
					return parniRoditelji(koren.levo) + parniRoditelji(koren.desno);
				else return 1+parniRoditelji(koren.levo)+parniRoditelji(koren.desno);
		}

		public void ispisiParne(CvorStabla koren, CvorStabla Cvor) throws LabisException {
			if(koren==null)
				throw new LabisException("GRESKA 1");
			if(!PostojiCvor(koren, Cvor))
				throw new LabisException("GRESKA 2");
			v_ispisiParne(koren,Cvor);
		}
		
		public void v_ispisiParne(CvorStabla koren, CvorStabla cvor) {
			if(koren==null)
				return;
			if(koren.podatak%2==0) {
			System.out.println(koren.podatak + " ");
			}
			if(koren==cvor)
				return;
			if(PostojiCvor(koren.levo, cvor))
				v_ispisiParne(koren.levo, cvor);
			else
				v_ispisiParne(koren.desno, cvor);
		}
		
		public int nivo(CvorStabla koren, CvorStabla cvor) {
			if(koren==null) {
				return 0;
			}
			if(!PostojiCvor(koren, cvor))
				return 0;
			if(koren==cvor)
				return 1;
			if(PostojiCvor(koren.levo, cvor))
				return 1 + nivo(koren.levo, cvor);
			return 1 + nivo(koren.desno,cvor);
		}
		
		
		
		
		
		
		
		
		
		
		
		

}

		
		
		
		
		
		
		
		
		
		
		
		
		