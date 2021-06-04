package kodlamaio.HRMSDB.core.utilities.helpers.imageHelper;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMSDB.core.utilities.results.DataResult;

public interface ImageUploadService {

	DataResult<?> save(MultipartFile image);
}
