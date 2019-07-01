package library.lgx.weixin.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lib_book")
public class Book {
	@Id
	@Column(length=36)
	private String id;
	private String description;
	private String image;
	private String name;
	private String storage;
	private String disabled;
}
