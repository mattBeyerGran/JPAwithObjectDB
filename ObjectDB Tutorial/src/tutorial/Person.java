package tutorial;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Person implements Serializable{
	// Die serialVersionUID wird eigentlich automatisch immer dann erzeugt, wenn sich eine Klasse ändert.
	// Das führt ggf. zu einer Exception, wenn ein älteres Object mit anderer 
	// serialVersionUID eingelesen wird. Man spricht dann von Streaminkompatibilität.
	// Oftmals sind die Änderungen an der Klasse aber nicht hinderlich und man möchte die Exception verhindern.
	// Deshalb definiert man sie selbst, wie in der nächsten Zeile. Man beginnt mit 1 (L muss man bei long Daten-
	// typen angeben, sonst werden sie mit integer verwechselt.) und zählt bei jeder Änderung +1 hoch. 
	// Siehe auch die Insel 2 Seite 682-883. 
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue   // Primärschlüssel mit automatischem Zähler festlegen
    private long id;
	
	private String vorname;
	private String nachname;
	private int age;     // mit gebDat ersetzen, wenn klar ist, wie man Datumsfelder serialisiert.
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
    public String toString() {
		String out = this.vorname + " " + this.nachname + "  ist " + this.age + " Jahre alt";
        return out;
	}
}
