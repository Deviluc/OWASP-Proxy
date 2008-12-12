package org.owasp.proxy.io;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.owasp.proxy.io.CopyInputStream;

public class CopyInputStreamTest {

	private final String sample = "This is a test of the CopyInputStream";
	private InputStream in;
	private ByteArrayOutputStream[] copies;
	
	@Before
	public void setUp() throws Exception {
		in = new ByteArrayInputStream(sample.getBytes());
		copies = new ByteArrayOutputStream[] { new ByteArrayOutputStream(), new ByteArrayOutputStream() };
	}

	@Test
	public void testRead() {
		try {
			CopyInputStream cis = new CopyInputStream(in, copies);
			while (cis.read() > -1);
			assertEquals(sample, new String(copies[0].toByteArray()));
			assertEquals(new String(copies[0].toByteArray()), new String(copies[1].toByteArray()));
		} catch (IOException ioe) {
			fail("IOException not expected!" + ioe);
			ioe.printStackTrace();
		}
	}

	@Test
	public void testReadByteArray() {
		byte[] buff = new byte[4];
		try {
			CopyInputStream cis = new CopyInputStream(in, copies);
			while (cis.read(buff) > 0);
			assertEquals(sample, new String(copies[0].toByteArray()));
			assertEquals(new String(copies[0].toByteArray()), new String(copies[1].toByteArray()));
		} catch (IOException ioe) {
			fail("IOException not expected!" + ioe);
			ioe.printStackTrace();
		}
	}

	@Test
	public void testReadByteArrayIntInt() {
		byte[] buff = new byte[6];
		try {
			CopyInputStream cis = new CopyInputStream(in, copies);
			while (cis.read(buff,1,4) > 0);
			assertEquals(sample, new String(copies[0].toByteArray()));
			assertEquals(new String(copies[0].toByteArray()), new String(copies[1].toByteArray()));
		} catch (IOException ioe) {
			fail("IOException not expected!" + ioe);
			ioe.printStackTrace();
		}
	}

}