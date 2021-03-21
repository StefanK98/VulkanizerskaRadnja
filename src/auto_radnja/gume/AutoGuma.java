package auto_radnja.gume;
/**
 * Klasa koja predstavlja auto gumu.
 * 
 * Auto guma ima celobrojne atribute koji predstavljaju precnik,sirinu i visinu,
 * i atribut markaModel koja predstavlja String vrednost.
 * 
 * @author Stefan Kujovic
 * @version 0.1
 */
public class AutoGuma {
	/**
	 * Marka i model gume kao String vrednost.
	 */
	private String markaModel = null;
	/**
	 * Precnik gume kao celobrojna vrednost.
	 */
	private int precnik = -1;
	/**
	 * Sirina gume kao celobrojna vrednost.
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao celobrojna vrednost.
	 */
	private int visina = -1;
	
	/**
	 * Prazan kontstruktor koji inicijalizuje objekat klase AutoGuma.
	 */
	public AutoGuma() {
	}
	/**
	 * Parametarski konstruktor koji inicijalizuje objekat klase AutoGuma i postavlja vrednosti za 
	 * marku i model,precnik,sirinu i visinu gume.
	 * 
	 * @param markaModel Marka i model gume kao String vrednost.
	 * @param precnik Precnik gume kao celobrojna vrednost.
	 * @param sirina Sirina gume kao celobrojna vrednost.
	 * @param visina Visina gume kao celobrojna vrednost.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	/**
	 * Vraca marku i model gume.
	 * @return Marku i model kao String vrednost.
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	/**
	 * Postavlja marku i model gume na novu vrednost.
	 * @param markaModel Marka i model gume kao String vrednost.
	 * @throws java.lang.NullPointerException Ako marka i model gume nisu uneti.
	 * @throws java.lang.RuntimeException Ako je uneta vrednost za marku i model gume manja od 3 karaktera. 
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	/**
	 * Vraca precnik gume.
	 * 
	 * @return Precnik gume kao celobrojnu vrednost.
	 */
	public int getPrecnik() {
		return precnik;
	}
	/**
	 * Postavlja precnik gume na novu vrednost.
	 * 
	 * @param precnik Precnik gume kao celobrojnu vrednost.
	 * @throws java.lang.RuntimeException Ako je uneti precnik gume manji od 13 i veci od 22.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}
	/**
	 * Vraca sirinu gume.
	 * 
	 * @return Sirina gume kao celobrojna vrednost.
	 */
	public int getSirina() {
		return sirina;
	}
	/**
	 * Postavlja sirinu gume na novu vrednost.
	 * 
	 * @param sirina Sirina gume kao celobrojna vrednost.
	 * @throws java.lang.RuntimeException Ako je sirina gume manja od 135 i veca od 355.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}
	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visina gume kao celobrojna vrednost.
	 */
	public int getVisina() {
		return visina;
	}
	/**
	 * Postavlja visinu gume na novu vrednost.
	 * 
	 * @param visina Visina gume kao celobrojna vrednost.
	 * @throws java.lang.RuntimeException Ako je uneta visina manja od 25 ili veca od 95.
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}
	/**
	 * Vraca String vrednost sa svim atributima o gumi.
	 * 
	 *  @return String koji opisuje gumu.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}
	/**
	 * Poredi dve gume, i vraca true ako su iste,a false ako nisu.
	 * 
	 * Gume se porede po marki i modelu, precniku, sirini i visini.
	 * Svi atributi moraju biti isti kako bi metoda vracala true.
	 * 
	 * @return 
	 * <ul>
	 * 			<li>True, ako su oba objekta klase AutoGuma i imaju iste atribute.(markaModel,precnik,sirina i visina)</li>
	 * 			<li>False, u ostalim slucajevima.</li>
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
