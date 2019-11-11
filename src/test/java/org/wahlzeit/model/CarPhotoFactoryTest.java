package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CarPhotoFactoryTest {

	private CarPhotoFactory carPhotoFactory;
	private CarPhoto carPhoto;
	private PhotoFilter photoFilter;
	private PhotoTagCollector photoTagCollector;

	@Before
	public void initCarPhotoFactory() {
		carPhotoFactory = new CarPhotoFactory();
		carPhotoFactory.initialize();
	}
		
	@Before
	public void initObjects() {
		carPhoto = carPhotoFactory.createPhoto();
		photoFilter = carPhotoFactory.createPhotoFilter();
		photoTagCollector = carPhotoFactory.createPhotoTagCollector();
	}

	/**
	 *
	 */
	@Test
	public void testConstructor() {
		assertNotNull(carPhotoFactory);
	}

	/**
	 *
	 */
	@Test
	public void testCreateCarPhoto() {
		assertNotNull(carPhoto);
	}

	/**
	 *
	 */
	@Test
	public void testCreatePhotoFilter() {
		assertNotNull(photoFilter);
	}

	/**
	 *
	 */
	@Test
	public void testCreatePhotoTagCollector() {
		assertNotNull(photoTagCollector);
	}
}

