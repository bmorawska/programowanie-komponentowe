package logika;

public class Poszukiwacz {
	
	private String pseudonim;
	private String email;
	private Poziom poziom;
	
	public Poszukiwacz(String pseudonim, String email) {
		super();
		this.pseudonim = pseudonim;
		this.email = email;
		this.poziom = Poziom.NOWICJUSZ;
	}
	
	public Poszukiwacz(String pseudonim, String email, Poziom poziom) {
		super();
		this.pseudonim = pseudonim;
		this.email = email;
		this.poziom = poziom;
	}
	
	public String getPseudonim() {
		return pseudonim;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Poziom getPoziom() {
		return poziom;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPoziom(Poziom poziom) {
		this.poziom = poziom;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poszukiwacz other = (Poszukiwacz) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (poziom != other.poziom)
			return false;
		if (pseudonim == null) {
			if (other.pseudonim != null)
				return false;
		} else if (!pseudonim.equals(other.pseudonim))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poszukiwacz [pseudonim=" + pseudonim + ", email=" + email + ", poziom=" + poziom + "]";
	}
}
