package org.prajval.EntityLayer;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectEntity")
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "technology")
	private String technology;

	@Column(name = "description", length = 1000000)
	private String description;

	@Lob
	@Column(name = "zip_file_data", columnDefinition = "BLOB")
	private byte[] zipFileData;

	@Lob
	@Column(name = "jar_file_data", columnDefinition = "BLOB")
	private byte[] jarFileData;

	@Lob
	@Column(name = "doc_file_data", columnDefinition = "BLOB")
	private byte[] docFileData;

	@Lob
	@Column(name = "video_file_data", columnDefinition = "BLOB")
	private byte[] videoFileData;


	public ProjectEntity(long id, String name, String technology, String description, byte[] zipFileData,
			byte[] jarFileData, byte[] docFileData, byte[] videoFileData, UserEntity userEntity) {
		super();
		this.id = id;
		this.name = name;
		this.technology = technology;
		this.description = description;
		this.zipFileData = zipFileData;
		this.jarFileData = jarFileData;
		this.docFileData = docFileData;
		this.videoFileData = videoFileData;
	}

	public ProjectEntity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", name=" + name + ", technology=" + technology + ", description="
				+ description + ", zipFileData=" + Arrays.toString(zipFileData) + ", jarFileData="
				+ Arrays.toString(jarFileData) + ", docFileData=" + Arrays.toString(docFileData) + ", videoFileData="
				+ Arrays.toString(videoFileData) + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getZipFileData() {
		return zipFileData;
	}

	public void setZipFileData(byte[] zipFileData) {
		this.zipFileData = zipFileData;
	}

	public byte[] getJarFileData() {
		return jarFileData;
	}

	public void setJarFileData(byte[] jarFileData) {
		this.jarFileData = jarFileData;
	}

	public byte[] getDocFileData() {
		return docFileData;
	}

	public void setDocFileData(byte[] docFileData) {
		this.docFileData = docFileData;
	}

	public byte[] getVideoFileData() {
		return videoFileData;
	}

	public void setVideoFileData(byte[] videoFileData) {
		this.videoFileData = videoFileData;
	}
}