package net.corda.plugins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InternalAnnotationTest {
    private GradleProject testProject;

    @BeforeEach
    public void setup(@TempDir Path testProjectDir) throws IOException {
        testProject = new GradleProject(testProjectDir, "internal-annotation").build();
    }

    @Test
    public void testInternalAnnotations() throws IOException {
        assertThat(testProject.getOutput())
            .contains("net.corda.core.CordaInternal")
            .contains("net.corda.example.CordaInternal");
        assertEquals("", testProject.getApiText());
    }
}
