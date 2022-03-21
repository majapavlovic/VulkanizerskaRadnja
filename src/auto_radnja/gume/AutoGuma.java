package auto_radnja.gume;

/**
 * Klasa koja predstavlja Auto gumu
 * 
 * @author Maja Pavlovic
 * 
 * @version v0.1
 */
public class AutoGuma {

	/**
	 * Atribut koji predstavlja marku i model auto gume kao String vrednost. 
	 * Mora biti najmanje duzine 3 znaka
	 */
	private String markaModel = null;
	
	/**
	 * Atribut koji predstavlja precnik auto gume kao int vrednost. 
	 * Mora biti izmedju 13 i 22
	 */
	private int precnik = -1;
	
	/**
	 * Atribut koji predstavlja sirinu auto gume kao int vrednost. 
	 * Mora biti izmedju 135 i 355
	 */
	private int sirina = -1;
	
	/**
	 * Atribut koji predstavlja visinu auto gume kao int vrednost. 
	 * Mora biti izmenju 25 i 95
	 */
	private int visina = -1;

	/**
	 * Bezparametarski konstruktor koji kreira objekat klase AutoGuma
	 */
	public AutoGuma() {
	}

	/**
	 * Parametarski konstruktor koji kreira objekat klase AutoGuma
	 * 
	 * 
	 * @param markaModel marka i model gume kao String vrednost
	 * @param precnik precnik gume kao int vrednost
	 * @param sirina sirina gume kao int vrednost
	 * @param visina visina gume kao int vrednost
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Metoda koja vraca marku i model auto gume
	 * 
	 * @return marka i model kao String vrednost
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Metoda koja postavlja vrednost atributa markaModel
	 * 
	 * @param markaModel marka i model kao String vrednost
	 * 
	 * @throws NullPointerException ako nije uneta vrednost za marku i model
	 * @throws IllegalArgumentException ako je uneta vrednost kraca od 3 znaka
	 */
	
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Metoda koja vraca vrednost atributa precnik gume
	 * @return precnik kao int vrednost
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Metoda koja postavlja vrednost atributa precnik gume
	 * @param precnik kao int vrednost
	 * 
	 * @throws IllegalArgumentException ako je uneta vrednost manja od 13 ili veca od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Metoda koja vraca vrednost atributa sirina gume
	 * @return sirina kao int vrednost
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Metoda koja postavlja vrednost atributa sirina gume
	 * @param sirina kao int vrednost
	 * 
	 * @throws IllegalArgumentException ako je uneta vrednost manja od 135 ili veca od 355 
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Metoda koja vraca vrednost atributa visina gume
	 * @return visina kao int vrednost gume
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Metoda koja postavlja vrednost atributa visina gume
	 * @param visina kao int vrednost
	 * 
	 * @throws IllegalArgumentException ako je uneta vrednost manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * /**
	 * Metoda koja vraca sve vrednosti atributa klase AutoGuma kao String vrednost
	 * @return sve vrednosti atributa klase AutoGuma kao String vrednost
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Metoda koja proverava da li su dva objekta AutoGuma ista.
	 * 
	 * @return <ul>
	 * <li>true ako oba objekta imaju jednake vrednosti za odgovarajuce atribute</li>
	 * <li>false u svakom drugom slucaju </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
