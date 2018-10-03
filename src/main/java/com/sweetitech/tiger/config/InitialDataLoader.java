package com.sweetitech.tiger.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import com.sweetitech.tiger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sweetitech.tiger.model.cricketapi.Flag;
import com.sweetitech.tiger.repository.BannerRepository;
import com.sweetitech.tiger.repository.BannerSizeRepository;
import com.sweetitech.tiger.repository.CommentRepository;
import com.sweetitech.tiger.repository.FlagRepository;
import com.sweetitech.tiger.repository.NewsRepository;
import com.sweetitech.tiger.repository.PrivilegeRepository;
import com.sweetitech.tiger.repository.RoleRepository;
import com.sweetitech.tiger.repository.UsersRepository;
import com.sweetitech.tiger.service.interfaces.IImageService;
import com.sweetitech.tiger.service.interfaces.INewsService;
import com.sweetitech.tiger.service.interfaces.IVideoCategoryService;
import com.sweetitech.tiger.service.interfaces.IVideoService;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${user.privilege.read}")
	private String READ_PRIVILEGE;

	@Value("${user.privilege.write}")
	private String WRITE_PRIVILEGE;

	@Value("${user.privilege.changePassword}")
	private String CHANGE_PASSWORD_PRIVILEGE;

	@Value("${user.role.admin}")
	private String ROLE_ADMIN;

	@Value("${user.role.user}")
	private String ROLE_USER;

	@Value("${spring.test.variable}")
	private Boolean testFlag;

	private boolean alreadySetup = false;

	@Autowired
	INewsService newsService;

	@Autowired
	private IVideoCategoryService videoCategoryService;

	@Autowired
	private IImageService imageService;

	@Autowired
	private IVideoService videoService;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private BannerRepository bannerRepository;

	@Autowired
	private BannerSizeRepository bannerSizeRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private FlagRepository flagRepository;

	//
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	// API

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
//		if (alreadySetup) {
//			return;
//		}

		addFlag("UAE", "AE", "http://www.countryflags.io/ae/shiny/64.png");
		addFlag("Afghanistan", "AFG", "http://www.countryflags.io/af/shiny/64.png");
		addFlag("Bangladesh", "BAN", "http://www.countryflags.io/bd/shiny/64.png");
		addFlag("Canada", "CA", "http://www.countryflags.io/ca/shiny/64.png");
		addFlag("China", "CN", "http://www.countryflags.io/cn/shiny/64.png");
		addFlag("Hong Kong", "HK", "http://www.countryflags.io/hk/shiny/64.png");
		addFlag("Ireland", "IRE", "http://www.countryflags.io/ie/shiny/64.png");
		addFlag("India", "IND", "http://www.countryflags.io/in/shiny/64.png");
		addFlag("Kenya", "KE", "http://www.countryflags.io/ke/shiny/64.png");
		addFlag("Sri Lanka", "SL", "http://www.countryflags.io/lk/shiny/64.png");
		addFlag("New Zealand", "NZ", "http://www.countryflags.io/nz/shiny/64.png");
		addFlag("Pakistan", "PAK", "http://www.countryflags.io/pk/shiny/64.png");
		addFlag("USA", "US", "http://www.countryflags.io/us/shiny/64.png");
		addFlag("South Africa", "SA", "http://www.countryflags.io/za/shiny/64.png");
		addFlag("Zimbabwe", "ZIM", "http://www.countryflags.io/zw/shiny/64.png");
		addFlag("England", "ENG", "http://a1.espncdn.com/combiner/i?img=/i/teamlogos/cricket/500/1.png&h=64&w=64");
		addFlag("Australia", "AUS", "http://www.countryflags.io/au/shiny/64.png");


//		BannerSize bs1 = new BannerSize("BANNER_SIZE_300x250", Constants.BANNER_SIZE_300x250_HEIGHT,
//				Constants.BANNER_SIZE_300x250_WIDTH);
//
//		BannerSize bs2 = new BannerSize("BANNER_SIZE_728x90", Constants.BANNER_SIZE_728x90_HEIGHT,
//				Constants.BANNER_SIZE_728x90_WIDTH);
//		BannerSize bs3 = new BannerSize("BANNER_SIZE_320x50", Constants.BANNER_SIZE_320x50_HEIGHT,
//				Constants.BANNER_SIZE_320x50_WIDTH);
//		BannerSize bs4 = new BannerSize("BANNER_SIZE_468x60", Constants.BANNER_SIZE_468x60_HEIGHT,
//				Constants.BANNER_SIZE_468x60_WIDTH);
//		BannerSize bs5 = new BannerSize("BANNER_SIZE_320x100", Constants.BANNER_SIZE_320x100_HEIGHT,
//				Constants.BANNER_SIZE_320x100_WIDTH);
//		BannerSize bs6 = new BannerSize("BANNER_SIZE_480x320", Constants.BANNER_SIZE_480x320_HEIGHT,
//				Constants.BANNER_SIZE_480x320_WIDTH);
//		BannerSize bs7 = new BannerSize("BANNER_SIZE_320x480", Constants.BANNER_SIZE_320x480_HEIGHT,
//				Constants.BANNER_SIZE_320x480_WIDTH);
//		BannerSize bs8 = new BannerSize("BANNER_SIZE_768x1024", Constants.BANNER_SIZE_768x1024_HEIGHT,
//				Constants.BANNER_SIZE_768x1024_WIDTH);
//		BannerSize bs9 = new BannerSize("BANNER_SIZE_1024x768", Constants.BANNER_SIZE_1024x768_HEIGHT,
//				Constants.BANNER_SIZE_1024x768_WIDTH);
//		BannerSize bs10 = new BannerSize("BANNER_SIZE_330x250", Constants.BANNER_SIZE_330x250_HEIGHT,
//				Constants.BANNER_SIZE_330x250_WIDTH);
//		BannerSize bs11 = new BannerSize("BANNER_SIZE_216x36", Constants.BANNER_SIZE_216x36_HEIGHT,
//				Constants.BANNER_SIZE_216x36_WIDTH);
//
//		bannerSizeRepository.save(bs1);
//		bannerSizeRepository.save(bs2);
//		bannerSizeRepository.save(bs3);
//		bannerSizeRepository.save(bs4);
//		bannerSizeRepository.save(bs5);
//		bannerSizeRepository.save(bs6);
//		bannerSizeRepository.save(bs7);
//		bannerSizeRepository.save(bs8);
//		bannerSizeRepository.save(bs9);
//		bannerSizeRepository.save(bs10);
//		bannerSizeRepository.save(bs11);

		// == create initial privileges
		final Privilege readPrivilege = createPrivilegeIfNotFound(READ_PRIVILEGE);
		final Privilege writePrivilege = createPrivilegeIfNotFound(WRITE_PRIVILEGE);
		final Privilege passwordPrivilege = createPrivilegeIfNotFound(CHANGE_PASSWORD_PRIVILEGE);

		// == create initial roles
		final List<Privilege> adminPrivileges = new ArrayList<Privilege>(
				Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
		final List<Privilege> userPrivileges = new ArrayList<Privilege>(
				Arrays.asList(readPrivilege, passwordPrivilege));
		final Role adminRole = createRoleIfNotFound(ROLE_ADMIN, adminPrivileges);
		createRoleIfNotFound(ROLE_USER, userPrivileges);

		// == create initial user
		createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<Role>(Arrays.asList(adminRole)));
		createUserIfNotFound("admin@sweetiTech.com", "Sweet", "Sweet", "Sweet",
				new ArrayList<Role>(Arrays.asList(adminRole)));





		createVideoCategoryIfNotFound("Vimeo");
		createVideoCategoryIfNotFound("YouTube");

		Image image = createImagesIfNotFound();

		CreateBannerIfNotFound(new Banner(new Long(1),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(1),new Long(2),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(2),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(3),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(4),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(5),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(5),new Long(2),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(6),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(6),new Long(2),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(7),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(8),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(9),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(10),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(10),new Long(2),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(11),new Long(1),"http://sweetitech.com/",image, new Long(0)));
		CreateBannerIfNotFound(new Banner(new Long(12),new Long(1),"http://sweetitech.com/",image, new Long(0)));




//		if (testFlag) {

//
//			createRandomNews(100);
//			createRandomVideo(100);
//			//addAdditionalImages();
//
//		}
//		alreadySetup = true;


	}


	@Transactional
	private final Image createImagesIfNotFound() {

		Image image = imageService.findByUrl("aa.jpg");
		if(image == null) {
			image = imageService.addImage(new Image("aa.jpg"));
		}

		return image;
	}


	@Transactional
	private final Privilege createPrivilegeIfNotFound(final String name) {
		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilege = privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Transactional
	private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role(name);
		}
		role.setPrivileges(privileges);
		role = roleRepository.save(role);
		return role;
	}

	@Transactional
	private final void createUserIfNotFound(final String email, final String firstName, final String lastName,
			final String password, final Collection<Role> roles) {

		System.out.println("---------------adding user init--------------");
		try {
			User user = userRepository.findByEmail(email);
			if (user == null) {
				user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPassword(passwordEncoder.encode(password));
				user.setEmail(email);
				user.setEnabled(true);
			}
			user.setRoles(roles);
			user = userRepository.save(user);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

//	@Transactional
//	private final void createRandomNews(int i) {
//
//		for (int x = 0; x < i; x++) {
//			Random rand = new Random();
//			int title = rand.nextInt(10) + 2;
//			int sum = rand.nextInt(40) + 15;
//			int des = rand.nextInt(100) + 50;
//
//
//
//			Image image = imageService.findByUrl("aa.jpg");
//
//
//			News news = new News(generateRandomWords(title), generateRandomWords(sum), generateRandomWords(des), image);
//
//			 newsService.addNews(news);
//
//			for (int j = 0; j < 100; j++) {
//				Comment c = new Comment((long) 1,
//						"test comment for user 1 and news" + news.getId() + "comment number: " + j, news);
//
//				commentRepository.save(c);
//			}
//
//		}
//
//	}
//
//	@Transactional
//	private final void addAdditionalImages() {
//
//		List<News> newsList = newsRepository.findAll();
//		for(int x=0; x < newsList.size(); x++) {
//
//
//			Image image = imageService.findByUrl("aa.jpg");
//			newsList.get(x).getAdditionalImage().add(image);
//			newsService.updateNews(newsList.get(x));
//		}
//	}

	@Transactional
	private final void addFlag(final String name, final String shortCode, final String url) {

		Flag flad = flagRepository.findByShortCode(shortCode);
		if(flad == null) {
			Flag flag= new Flag(url, name, shortCode);
			flagRepository.save(flag);
		}


	}

//	public static String generateRandomWords(int numberOfWords) {
//		String[] randomStrings = new String[numberOfWords];
//		Random random = new Random();
//		for (int i = 0; i < numberOfWords; i++) {
//			char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are
//															// boring.)
//			for (int j = 0; j < word.length; j++) {
//				word[j] = (char) ('a' + random.nextInt(26));
//			}
//			randomStrings[i] = new String(word);
//		}
//
//		StringBuilder builder = new StringBuilder();
//		for (String s : randomStrings) {
//			builder.append(" ");
//			builder.append(s);
//		}
//		String str = builder.toString();
//
//		// System.out.println(str);
//		return str;
//	}
//
//	@Transactional
//	private final void createRandomVideo(int i) {
//
//		createVideoCategoryIfNotFound("Vimeo");
//		VideoCategory vc = createVideoCategoryIfNotFound("YouTube");
//
//		for (int x = 0; x < i; x++) {
//			Random rand = new Random();
//			int title = rand.nextInt(10) + 2;
//			int des = rand.nextInt(100) + 50;
//
//			int urlNum = rand.nextInt(7);
//
//			String[] demoUrls = { "_BFXCgm5270",
//					"_qy4s3F9P6I", "Ij99dud8-0A",
//					"SyRHeyFdl0I", "SbWeP7KkeCU",
//					"a8Z2jSATjqQ", "WxnN05vOuSM",
//					"h8IuFl3sMhk"
//			};
//
//			// String demoUrl =
//			// "https://www.youtube.com/watch?v=_BFXCgm5270";//"http://demo.wponlinesupport.com/prodemo/wp-content/uploads/2015/11/wordpress-free-news-plugin-1.jpg";
//
//			Video video = new Video(generateRandomWords(title), demoUrls[urlNum], generateRandomWords(des), vc);
//
//			videoService.addVideo(video);
//
//		}
//
//	}

	@Transactional
	private final VideoCategory createVideoCategoryIfNotFound(final String category) {

		System.out.println("---------------adding video category init--------------");
		try {

			VideoCategory videoCategory = videoCategoryService.findByName(category);

			if (videoCategory == null) {

				videoCategory = new VideoCategory(category);
				videoCategoryService.addVideoCategory(videoCategory);
			}

			return videoCategory;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());

			return null;
		}
	}



	@Transactional
	private final void CreateBannerIfNotFound (final Banner banner) {


		try {

			Banner bannerCheck  = bannerRepository.findBannerByPageNumberAndPosition(banner.pageNumber, banner.position);

			if (bannerCheck == null) {
				bannerRepository.save(banner);
			}


		} catch (Exception e) {
			System.out.println(e.getStackTrace());


		}
	}

}