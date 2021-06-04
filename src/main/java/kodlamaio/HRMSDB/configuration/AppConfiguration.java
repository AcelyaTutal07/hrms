package kodlamaio.HRMSDB.configuration;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HRMSDB.core.utilities.helpers.imageHelper.ImageUploadService;
import kodlamaio.HRMSDB.core.utilities.helpers.imageHelper.cloudinary.CloudinaryImageManager;


@Configuration
public class AppConfiguration {

      public Environment environment;
	
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dyys03ood",
                "api_key", "274511997862632",
                "api_secret", "drmB5cP5k_frYHDzFvdzco1lLTk"));
    }

    @Bean
    public ImageUploadService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}
