package backEnd.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data@NoArgsConstructor
public class contrat {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;
    private String fileType;
    
    @Column(name="date_debut",nullable = true)
    private LocalDate date_debut;
    @Column(name="date_fin",nullable = true)
    private LocalDate date_fin;
    
    private String type;

    @Lob
    private byte[] data;

    public contrat(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

	public contrat(String fileName, String fileType, LocalDate date_debut, LocalDate date_fin, String type,
			byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type = type;
		this.data = data;
	}
    

}