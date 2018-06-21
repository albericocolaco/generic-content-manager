package br.com.contentmanager.specification;

import java.sql.Timestamp;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.contentmanager.entity.ContentLiv;
import br.com.contentmanager.entity.ContentType;
import br.com.contentmanager.entity.System;

/**
 * 
 * @author alberico.silva
 *
 */
public class ContentSpecification {
	
	/**
	 * Construct.
	 */
	private ContentSpecification(){}
	
	/**
	 * 1 Equals 1.
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> oneEqualOne() {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(cb.literal(1), 1);
			}
		};
	}
	
	/**
	 * And ID.
	 * @param id
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> andID(final Long id) {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("id"), id);
			}
		};
	}
	
	/**
	 * And Date Create.
	 * @param dateCreate
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> andDateCreate(final Timestamp dateCreate) {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("dateCreate"), dateCreate);
			}
		};
	}
	
	/**
	 * And Date Modify.
	 * @param andDateModify
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> andDateModify(final Timestamp dateModify) {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("dateModify"), dateModify);
			}
		};
	}
	
	/**
	 * And Active.
	 * @param active
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> andActive(final String active) {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("active"), active);
			}
		};
	}
	
	/**
	 * And Content Type.
	 * @param contentType
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> andContentType(final ContentType contentType) {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("contentType"), contentType);
			}
		};
	}
	
	/**
	 * And System.
	 * @param system
	 * @return Specification<ContentLiv>
	 */
	public static Specification<ContentLiv> andSystem(final System system) {
		return new Specification<ContentLiv>() {
			@Override
			public Predicate toPredicate(Root<ContentLiv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("system"), system);
			}
		};
	}

}
