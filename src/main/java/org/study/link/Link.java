package org.study.link;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "link")
@Entity
@Data
public class Link {
	@Id
	@Column(name = "short_link")
	private String shortLink;

	@Column(name = "link")
	private String link;

	@Column(name = "open_count")
	private int openCount;
}
