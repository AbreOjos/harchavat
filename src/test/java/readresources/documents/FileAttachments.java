package readresources.documents;

import java.net.URISyntaxException;
import java.nio.file.Path;

import static automation.tests.infra.helpers.resourceshelpers.ReadResources.uriFromFilename;

public class FileAttachments {

    private FileAttachments() { }

    public static Path getDocumentPdf() throws URISyntaxException {
        return uriFromFilename("documents/hiringProcess.pdf");
    }

}
