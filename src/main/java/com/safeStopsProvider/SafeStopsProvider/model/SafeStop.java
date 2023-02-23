package com.safeStopsProvider.SafeStopsProvider.model;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	@Entity
	@Table(name = "safestops")
	public class SafeStop {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
		
		@Column(name = "name")
		@NotNull(message = "Required")
		private String name;
		
		@Column(name = "description", nullable = false)
		private String description;
		
		@Column(name = "rating")
		private Long rating;
		
		public SafeStop() {}
		
		public SafeStop(Long id, String name, String description, Long rating) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.rating = rating;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getRating() {
			return rating;
		}

		public void setRating(Long rating) {
			this.rating = rating;
		}

}
