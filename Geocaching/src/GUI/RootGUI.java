package GUI;

import logika.Poszukiwacz;
import logika.Poziom;
import logika.Root;


public class RootGUI  {

	private Root root; 
	
	public Root getRoot() {
		return root;
	}

	public RootGUI() {
		root = new Root();
		
	}
	
	public void dodajPoszukiwaczaDoBazy(String pseudonim, String email) {
		
		String sql = "INSERT INTO poszukiwacz VALUES ('" + pseudonim + "', '" + email + "', 'NOWICJUSZ')";
		root.dodajDoBazyDanych(sql);
		root.getPoszukiwacze().add(new Poszukiwacz(pseudonim, email));
		
	}
	

	public void usunPoszkiwaczaZBazy(String pseudonim) {
		String sql = "DELETE FROM poszukiwacz WHERE pseudonim = '" + pseudonim + "'";
		root.usunZBazyDanych(sql);
		
		Poszukiwacz p = null;
		for (Poszukiwacz posz : root.getPoszukiwacze()) {
			if (posz.getPseudonim().equals(pseudonim)) {
				p = posz;
			}
		}
		root.getPoszukiwacze().remove(p);
		
	}
	

	public void aktualizujPoszukiwaczaWBazie(String pseudonim, String email, String poziom) {
		String sql = "UPDATE poszukiwacz SET email = '" + email + "', poziom = '" + poziom + "' WHERE pseudonim = '" + pseudonim + "'"; 
		root.zmienBazeDanych(sql);
		
		Poziom poz;
		switch (poziom) {
		case "NOWICJUSZ":
			poz = Poziom.NOWICJUSZ;
			break;
		case "UCZEN":
			poz = Poziom.UCZEN;
			break;
		case "CZELADNIK":
			poz = Poziom.CZELADNIK;
			break;
		case "EKSPERT":
			poz = Poziom.EKSPERT;
			break;
		case "MISTRZ":
			poz = Poziom.MISTRZ;
			break;
		default:
			poz = Poziom.NOWICJUSZ;
			break;
		}
		
		Poszukiwacz p = null;
		for (Poszukiwacz posz : root.getPoszukiwacze()) {
			if (posz.getPseudonim().equals(pseudonim)) {
				p = posz;
				p.setEmail(email);
				p.setPoziom(poz);
				
			}
		}	
	}
	

	public static void main(String[] args) {
		RootGUI rootGUI = new RootGUI();	
		try {
			 	//InsertPoszukiwaczGUI frame = new InsertPoszukiwaczGUI(rootGUI);
				//DeletePoszukiwaczGUI frame = new DeletePoszukiwaczGUI(rootGUI);
				//UpdatePoszukiwaczGUI frame = new UpdatePoszukiwaczGUI(rootGUI);
				PoszukiwaczGUI frame = new PoszukiwaczGUI(rootGUI);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	public boolean sprawdzCzyIstniejePoszukiwacz(String pseudonim) {
		
		for (Poszukiwacz p : root.getPoszukiwacze()) {
			if (p.getPseudonim().equals(pseudonim)) {
				return true;
			}
		}
		return false;
	}


}
