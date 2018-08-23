import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.util.*;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.io.FileUtils;
//import java.util.Scanner;
import java.io.PrintWriter;
 
public class mlPostprocess {

	public static void main(String[] args) throws Exception {
//TODO 3 java - mlPreproc, mlWeka, mlPostproc
	String csvFile = "data/before/simData.csv";
	BufferedReader br = null;
	BufferedReader lr = null;
	BufferedReader sr = null;
	BufferedReader sr1 = null;
	BufferedReader sr2 = null;
	String line = "";
	String line1 = "";
	String line2 = "";
	String line3 = "";
	String line4 = "";
	String cvsSplitBy = ",";
 	
//	Obtained from summary after running generalization 

	String[] SUCCESSFUL = {"03cc90e704819e4e7ad7dcf44ff3e744","04982bc2416e05b62154602fbf64fabf","049e8e8172674a9c376e169840d43bc6","070e5a24d14fb74d79ed7e652b5f19eb","07453de0c566cac4777f9776de554cd0","09eb8e385a8622089db31a3cb4883fd6","0aafeccb138c3bd265ed65859351502f","10174a3cec34b7fafdbcf56fbc6a9030","106934e24ba5655e4b9b514556ed5b7b","108ab314186c14e8de7ab358cd77148b","12f6ac1fe9b21c3ba85c7aa433252549","14cc8d650fe183f0ac3c073d5755ca40","14ec9a951a586aaefe4645c32db44708","1586c3f93d56231c1ae5a49a5e2f9956","15afd232abd5cef53f9d374d63c2c51d","15c0ccde9f648e5a48ccba8a53722747","162f109662d3ff74a2a7ad78304a42a6","167686e2611ed27c1f54c09238dc10cb","16c9634cc6894369b3954fc6afc7d88f","16e95d1ec45c064192fc317d64ab52b7","16f49b073e658fcaa10d14b8567e719b","17a9987e783824e45d37c7e99877e872","1910cd134439fb746111f29ac4ed2b4d","1a10aa9a4a8da1ed87749f3407b48184","1ae23cf78a9f14ccbb098ae09221fcb2","1cdbaca51760e0eedd06175c7825b6fe","1d5249a8d9c4878abb72e4ef4a4ddb54","1d7ef13ee01dd243b04c32defc6d1295","1deeb746cf67bab72de64ab671354765","1f2bff48eb0a8e33b92b26a84e638c3b","1f91cc699002d5b93600c9c271d25515","2051e5bdbc09dd8fcf03b346c585c97d","21427c78f7033171ca718efa334492d9","21cdf17562641abd596ad162625eb1ef","22cb62c8d842b09553463f17898321c8","23f05ad5fc966fea59dffbedca16a592","26dba01dac0f62de859cef88852aacf1","274ea0d632926eebefecac44dd5f036b","2c4b8abdcdcc6518c78de6b29fdd2a98","3184fbe2a601f265f04752d56a8302a4","31b482f51ebccf7539933e11a7775d15","32ee0b9a86c55542e5b8b40eb61e5403","35fb56cb84b72f11d8e700f11aaf6a35","37a5df03b5401e41cd1ccb07c6a88a59","39d16db391af4492465142631917277f","3c05cec240645f2b78e83a85039a9ae7","3c0a3711134b4714e07c7add4fc28225","3c1bab74c3221a96a046bafca6e9c163","3cabc968602c23202cc5eb079e80bb55","3deae07c01e124e957aa0462d8f2a8b4","4096d70adb4230ec9f685dcdd7905492","40ac9dee0405abd8740eb04b07689b14","40c58e5fb86382834915234602f2264a","41e693a3fe3bc644213dab0dab4e621c","438a91a84fbaeb691334ffc32523a9e7","45336320eb5a69f504710329c3c41687","458aba5dc4b895d84f0fa22d987f6c0c","481b31f99fe4ca4e8894f73dcdc348e2","48e34c39b2ddcddd2a348d5edd967762","4a5db2bcf213d73573cd8bfdc0d2ba1f","4ab15cbeec705f9a9edbfec0ee60df88","4c06fe129db5d98acb1cb77b4e2c83d8","4d2eb33c2cea349591dcb33d0a3079a6","4e96172e812ebd5e68151029546db1ab","4eeca5265d86c26db6e37ce892844843","501a42f6f122788cc44b7ef876d5526d","540df5357f001930b354e70475029b86","55b3ee44c5742215ed101f6d2c641ff0","562c279fb0ba243b292742a64db8a54e","5680adbb85706386c6ada47702e2ad41","59e524ec0613a50b5393b8a92f40a858","5b772be1d538ca3e29f4807e6ceed2e2","5ba6876123780b44def7a320aa116144","5c790f5be76d89d2367179d6dbbae13f","5e5678a328ded6cc72de622c3b05b21a","5e77cc4a47440fe9d48f3b61b63bde85","5e9ba5d7d37a4ebd2d2a8c7a375b0456","5ed9b831d04a125e5cc1a46c9c1e116f","5fb92943ddc0175360bbb63d339988e7","5fd66f5cae4ff14526cdb0fb885a1003","6107823c6a34e1708bd2e5e1a6626037","6158e8b9688e6f5350c343162ddc7041","630dfe0442e8e0c231fd38f69fd6fc48","647fdea97afb67118fccd92888289442","64d92c8cb92f508ac9087beec02b2683","6966d0c1e2440b5a4b4f43fad4f6e74b","6a323615aa1221336184bb14a6e7ac75","6c621f8de1ac6f63abe9515b34e3697c","6d29c68cae6ded13f0a9de2b96cdbfeb","6f58f73d41a9a9171c7db433f0413ed5","6fa1cc6b1d4a8eb401c956c03dde75da","700838ff9273f9c8b5a0bc5199cbbd71","71b9d1a011095da1744c248ae0c3aa92","7448dc17fe2ec5432e092820ac861839","744d3b78e334156e7c4c680497f9e378","7495423a757e7100c85cf37328e9f8fc","74adaf4168bbbf4dd35c57eefa9164a3","74c59671041bf86ad0e074b692f9654c","74e8796e0ca20a706ef21069ef507d91","753d0b83b159dc0ceca24e871451afc1","797a4930285e1c1a84b19f0fc0e7837b","79a0c60fd067db1f9a43e7e4eb6b125d","7aff1809c68247b25088e3ff7b51a54d","7c089df14beb12e2b1dceac2a2af7a8d","7caa304c21dfddf845b20493db6e1b6f","7d2182bf9fe2154197cbc093074d55df","7dcd33844930ae3f76e196e3f09f36b4","7e5e4628d35c6b158781006fe54f271a","8042dfc14734f5cc8aa1e1161c4e54d0","86dadb4216c18e35f143e16eb44b4695","87c842da1866497d345b04d9495fce00","87d5dd447cc0394eecfa1476f0f24f6b","8a1f67ced500420b0af46b9ac3739579","8a424ba08b6933585612dc2340ef3019","8abb3ce8b3b332488a3c886fa2b17b71","8f4f464555fe873aae5fa056b309471d","91147d2e1c57cdd2309a7436d50593b1","92da7c0c45d67ad464dcac5d639fc0a4","942037fa4bb19e8d0ba4c9b5044201c4","954fc4c6736bad04522944248afaa991","95cae558dccada9e6846058e8a9c1b26","95f345136894893813b671ed367f5b55","96720483b7eb88b76f1e1a818d03e1c3","96f4d3e53678863ae7b692d75306056a","980aa386ab53772af94811d5fbf9964a","990a9fab8f5583519ecdaeef6d8e628a","994d15c7744b08cd52a1ef16863e0178","9a436b739cead4db3e1430e69f061af6","9bdba4b009d4d3b999099212bc74b3ad","9c4fcd82a5d0dc180ffb658386cd7816","9e4c205275bce00c283d5c22fca244e2","9efec2821b2eac33b95d0e24af4274aa","9f5a4f77ce75c5ecf970a4aa2c3fb998","a28f552d0639ff2bdccd2a43c9722ec8","a3d717fba790674b386109f86b3f92ca","a6990a75d3aa1c369b5326f0bd53b735","a8434ac5070b859ae90eef3ed56ba62e","a94730a1dc9fff0fc29804b17a884bb4","ab552565e4e74eba84f4be13674b4fd5","ad8cc780823e2ed955d2da55f8a2091e","add3f82f5b1f66cdb44fafd7a8f91117","ae6881ca90c21d763a8d887007cef479","af58d6b7fa498a4053525be637943303","afc4480414dd8bafeec85f44202274d6","b1fa67085cfb28e9f321d4b9a0ca974e","b25af487c221d4d645ddd36380b657d4","b2a38c285081d588eab7f1f5b1de824b","b47a354eb02bc6aaaa5b08a4f874433e","b7b841710759393d973189eb421d7b8f","b84158fc812627ac71df4b5529f7c825","b90d28c70dca06c9ab378c933523198f","b972a80f55b3402b351cbeb804ccb857","b9d2d269c120dd01f0caf8ad76b01bae","b9d55b3e7d6f7298df07174acf99f9a0","bad95d551e7595b76a646a0025edb34a","bbbb5c8ef142e2949aaabc09bc1546bd","bca345da48e1943d1a265944b2c8468a","be3408ad355c8289ff50c667f0c2899b","be6cd2fee4fb3becf2ba03febb88153d","bea5260b04873e6ade5bb069eb246e03","bef9d284c7096c95f8acc2fcdaab4b4a","bf3266550d0efa8185c828bf14202b0d","bfda00c63278badb697f5ca2c1d0899f","c3dcf0464f7e235027a64915395ba53a","c4df6443b0bfb77e8a171265b7192c03","c53b706f94ef84f2d4e2dcd5a5b9c3a8","c6d2e6cc0c458f37d96ef25cbabe5a9c","c8c08daa5023a8504fa5e1db43a3bfdf","c9b88071a8e40c7fc50ec324e407efca","ca04e700a7f62c3d11d9417f6e3a76ec","cb2c997974de2fc00df8768d3d190115","cb3b27d3f97736e3f48940c1e9be689e","cd6dbfedee2932dc3f39ecce48d77e7d","cdc2f1fc18e17ab4d1f8a09c2870c9ba","ce980103cb46dc6b7dfb3691f0c1396f","d2083b593ca0b14bde569b20b36c22ec","d5560a9df004271ff4e2398dd72dc9a8","d83829b0b78ea7c05fd787ce0e630c09","da93ae5bbed334eb14c10da2f6549372","da9a441ca5f79b71d10fbf0a2cf48280","db4787bb688e2774ffab17ef75d2b3c5","dc035681f47cff840624d11a765f4066","dc41dc1127691796d86a50c1cec10f5d","de47e157f26e0a36a92dcab25e1b51b8","de6075c3ad7755c7648ad6b51bbd2348","dfe409f880dbc5eff5678e5ef2bd09a5","e115dd1f5b00bd5bf114c250dbaa8d66","e133499d7e505aae81f2925415de5c57","e265f32dfa23992291dc29df05695349","e33c654f0f1b0e716944e44246f20f34","e45b50201549df8b63c434715add12e0","e4c668f9b6bdfaf46567a25758b97056","e75612489a13dd37225ef798f6d5b905","e96ec71eac5fca7d87d54cbf4a9bfb6b","ebaddb65a6a38507ff846a8d2a9f6e85","eccebc36219c1b7808858ab5a8483c7c","f2f14b6d63d721e4657ecaf0cf953d83","f36f233c5e2b04adb77953421a307d2c","f4f0c076b7312358357cab6964eadb7b","f55041d0f86bbafd5e7b3d3f35d7e325","f6ca54ee1a81682e80f5e659c40e4aae","fb1b71bedb05a94a7dfad4ca5b02b9ad","fb289b3f73dab3747cf3016be9ec367b","fba7d96df1ed42fbb7135d193efc9dc3","fc07597709cabad5762e37c9ef907ae6","fc5b6e91c5443061fdbd66eaad1835fe","fced8a1161d43eaea964795a70e7877a","ff1bda57f464882b63a0db7869857dc6","ff5bba92cbd50599d59ab871ada1a7aa","ff74cac34e53da2a0cb6c8e147f7f75b"};
	String[] OVERGENERALIZED = {"00fe8cfcb2da8034df19f1b34164c2cf","021292fdfd3cd80665b97caf72689f5c","0242295e396d4f091048639d20b1154c","025f700e49cbc3c4379ed67fac42987f","03e2df31dffce8ecc71824486313536c","041966b2d62f6c3d9675dbce1d65be8e","058a50442cc0adc6da4ead8ef5d0205c","05d2a284564290e2c76927b4a7db1713","05e1de5fe71e7892c39d8e289ff08a31","064d8383873a90531fce251508d62d9a","07a717e5c2c5a75bbc9bbfb9d3483eaf","09ad4ce1a7b845967bf958d948f7affd","09c1c95167a3bb8ce170b9a0d516c52a","0ab39fc30608ef21f248fe71597db9ba","0b2d4aa9e198594a3dffe0c2bb01e771","0c4e508a0a573244062ae2bcb72b7854","0ef0f1e039ea6261758fa90b1332aa86","128f9385ca38892b7fb07e776e2a2c91","14536291ce3c2372e3a43a7b25e7a4da","146fe1c45e4f9591f6efd872eb59d84c","1604bb8419223f1626933a9fefaa74e1","161fd48da070288cd7759b70166c26f6","164f3786aa585f61c0b7ca15bdc6c09d","1904a5c80c7c7727f10bbf2a84026afb","1b987ee3508b3984bdb5db48125b7da4","1c75d2e50e5fc4272c5706655f485c8f","1cd9d0d6b5f74e332536ea7d9e614037","1d270acdcf28297abae23cc32e4a4b9f","1e005ca3123d45919c5cddd8f4c47756","1e28c85fe007f3dfb60ecbe130bc4c91","1f452c1cd22414ee7fd150f2df106503","1feb8e14525d7da9f8a44577822d3e67","20d7ee56dfe64fd78eefc3d4faad3a63","21dfba04456c721ec42051dfc04d1e1b","22be48e2223ac1f7d26f46cb38ffbb4e","252e5d0ad335e86408f9bd0225c0a276","27f74be1f74044237bae72cb480e33bf","28760c7b96a1fd2030a10ef1232d6625","2917b4c3527740990fd09c270c4a56cc","2a35ca26fa50ee6a68445d16e6f0dc8c","2a7bc1bb3fc477989f34625af73e51fc","2b65eeb1f6b4392ddc97d92b6ed8c2e0","2baa0e6786e662535b546aec7f6c68fb","2cc6eb8ca88d9d0970e618c54bebcc33","2d14c319d33e482cb3187682a190cee6","2d7b59b1f9ccb1acde05a1f796bc2d72","2e696278493c6d383bb93c837385f8a6","2fa41a3f5d22f52a6bbfcd94c79884ad","30e9ea77defa741b703b3c84b4266cee","32f6bd4db6780302fede088c4d7cb8fa","351f5b5045cb35c3d632ac47fd12e09e","3550238fad0c6df9e1649e1cfbefaec4","3700948bfcde51c7b6a79529bda5f356","378adbf35fa9f25449c07db2624afccc","3865b281c6f80b78fb3e69a1d2275159","386f2dc16928a4f07614ea7f7b966ef4","3af4b1f1b4a6d691c3b2a1443c04a60d","3d5007eb4cb914f501c5173875f2d712","3ddbab784b55621e6de2b3aa3cb7b964","400bc6663fce6bf128cc631117fcc982","41e3987eb56eddef5e31bb83f01982ee","42386a08904dba8b549a9c4b083d13d1","4354ce8c49089d9d1dff7840ccf04756","43875c2d86e1f5ed67560cf57619cff0","43fb34a72e3820f2f2facf41b5cd0381","454259988471e986b7fd99d70922431b","455f3faf2eb7702343e212b7ba35c86a","472eacdff9519a87b5cbc7e801b223a3","47f616e1c21851889a80f282756cde7c","48175c413a8f419812a5e514c3719889","49b1cc5d59d07afc45ec52d2c06732ab","4aa2716346f06ae271ecdaef8cd9dda4","4bc0d4551f7aba9b66e8a2d236fb1683","4d27ab140eedf5f45dfda09eca52377c","4f5134cca651c0379774b24b95b6e9ba","4f80d1be09c2883af89a6a27b5e3fbbb","52d1d7ca0a6a4051935adc0f07ff5b89","539fdfb4b29a0f8a2d16fbda4616f151","53b894d2ceab0ce392251e3b11e537a3","53c897d5fe8145853d4f905ab3182386","54a2d10897be96956777014e3c3b1800","559080d96471cfede86ca02fa6545552","55f02566c506d13b0716ab8cce5fd88b","5638141fdc7f13dbcc2fa2331d644870","57c228263600bec41956458f4937e04c","5818e8b2e91dc183e6f912f75916c583","588437537f6711c2f9e9056688b32803","58aa0b0313783e7105b5dc3c935fb668","59daa84cbeace0cd43e573eaed4196f2","59ed24a53de51b4c821b8d3d60e71ef2","5c45ba9dd63d031e895e60a11ce01da1","5cea4234aa1e09ec1495709e34e01e9d","5ed8d4d198c90a380aa9ca01f0ad0a31","606119cde9595e70c1d169170ba083aa","627f81474feb996b3568dc7a21450f4e","63848de18502a272808e551873abf98a","63b253793d30bf16fafc9b9337ac671c","63faa2cea0e028b2c7b5564e02a02d4a","64acb2df9b2f3be49fb9b54c4f860bd6","64d1e4094891a68e51d370fed39943e1","657ce08a43deed6a9c906a639a01bbb5","666318003de78e36db9aef752a89a826","668fc5ec1f292256728a1efc284a558a","679d714eba6f239a6e8de9186ceda10f","6b50db4e26a34fbb8435de96af506a82","6c5af5d178e80ebc91fcdf4602494577","6c7bd5a2a1757c650d37a5232f6fcc4d","6dde1aee3520cd3cd8ac12b4c227715f","6eabea995a14717b5f668f5cc9ba9de0","71cb303b891a61d0031c2ca56fe4d6ff","729b5e8cbdf24b732e9a2fc84da5e724","731cdde4de60c99f00a433221f399d39","744d52436ac269ef81b6791ebb762245","762b9abf9d9a6c06d8c1b01e640b3d6e","7722824108b49fc11347dac1a3339dae","791110ddd635aeac658ba88b9ce65760","7981e096e4ef81f2249b2176db6cff9f","79eb4f09fca258f43715fd581a6cb909","7c74e61537fef87aadd0bc8f23d21577","7cb4b68abaf961eac7adc6d329872602","7fa26c6147c3c25ea2cc1946b718ae6c","7fee09ccecf0daccfe60b2dfcfe11d77","80b0eee07724e45bdc09d0c10501c70f","813ecf3c768a0dbb93f350b0b5012045","840b68876cb4e807ff1834e95778933e","842297e801b327e7fe69255d6bb4d273","842ecaadb4dd19a2558f25de30b1c65f","844d34e6105ecbe9fac19f2da430dca6","85d574960068ae89e528441f6289fa8d","8623bb37e4295c378f481300ba9b802a","87076810e6c8688e035e54bcece85c9b","8726a400f17cef0c5a87bed0b03edfa3","888675fb423d8dc7957d398d4eae0eb3","88a9ca71fd9d38c3290d53397e5ff90f","89dd4bd46a716898ce9689dba684fa1b","8a22e4a8891503165afa70d5b4a6e827","8cfde7b0d7946ad3cb62d60556b5df1c","9092d8102bb8d2c05f8d17ac307583f6","94ddb689fcd5ad49e5ad0dcb377dcf99","9528b2d79ee7af7bd2e34320287cf4e3","95d661031c596c11a00a8c27c729ef60","95fcbf3aab4efea0eaba45c6354f9da8","963f86adb73b5dc82cebc06a6a553fe3","98aa6dfc2629341396fdeb9f45679333","98e717a6082f3824ffa6107bfee62d18","99a224efed6c0ca5a942cdb71ca3c8a7","9b6c949a3f08c1c13e11dc4e54d3df0e","9be77e89ddcb343525205a869fb5c80e","9ced2bf60c251c66c1eaf3110b96cbed","9deac47cfdec1ac3a687eeb5e9bcff4f","9e70edf5886269387b86336b2a2a35ac","a12f0d5da2fb031188d83458acbe19b4","a18cc897a4473c196160d62326545485","a193320f99c25af2a533f3ed84801058","a3562ef2a122d2548119bfa3b94b5ee9","a69b466c5f7612a8480e35a52b4a6a20","a6b18cdc59ea8258376da277f4255ed5","a73253cc5e980e008330688ce76dc6c8","a772a27ad70bd62a2a4f062fe70b5c0c","a877fb55fae35b25ddfb518b2a17d20c","a88ccc8d67b35b22ec19113bab1914fe","a8b00e6abfc515d74814207611b6a297","aa4ef298127d2732a71f80bae1aef3bd","ab31c75d831038ea0a1ca508c1fb9805","ad6bb0bccb01fd5790cf175078be46ea","adae7e1c34614bbe233127d4f7a5a8a0","adb0f184234526cb230f8aed7c08b53a","aed02b3a3b75f00f954ae739d245360b","b068d57f91ded812f7dbc6f71a6bf778","b308b2f3e28aa371b7d7891a723d01d2","b53bb4cbe634eb8feb67b215ee9026ac","b57e061809f68e16d27606ed663a9e16","b59e016e5afb55f1bab23e5226c42a02","b6591bc993e7ae6476b98e7c742406ee","b70f2b9fc5656b1e132e5fea3039426a","b7c8a24cbecfd609c0a047b77140c68b","b7e7bea074663a2c5c7ba7a60ce2c74e","b839bd8e31d84c7b9bda9a36fcae0585","b9f5b5ec5e888bb800cdc0571ca304ce","baac28825e7ea32c06b9fb7511a45f16","bc0e4717b5530c1a0c2a0f9a5d55921c","bd63d25305ea40556557439e69dcbfbe","c0580bce2ef42c76b165fc46cf7215a3","c0844037bdb78d67f5dbc3988f0920a6","c1a096a57489f63cda2802c058bf0ed9","c208125c0494b4cfe25114c2cc2813a8","c23cf08ccbc4c6eab0508c6850382da2","c40085ece5a2f62776fdc079c103d875","c6a7c91c316c62fe0a914bf28eb9adfd","c712f521bfa447ec1a6ce695d61a6800","c778f3d90ec0697fe958d09ab16effb2","c7cc7c50717b474d8572752aa3a0d761","cb679fdb719fcf81732b0bd144abf360","cb8b732b26fe7095b97122f4d6c24ae1","cc0847b54f8a74839f5f82d7395a743d","ccc00ef3ceb09e0dc0c57884f2a5c9b6","cd2bcb2e2bfed9829fa9499a5923a16b","cd3809a0922dd76b28bed3de322575fa","cd3df2cc817746aa4ff2ee57b5c8f74a","ce601b73cfaf156deeb34e5cba2f7ed5","cecf687cae271a35982164809a5b3199","cfe916817fea00ee81b06860564b24ec","d039af9e828beb60252305f91f66981a","d0b287fddcfa6c65f6241d8c701e4714","d0fd626abb35c6ab796a1bd6641ca144","d33cadb113e17d44cb60a9e28d488bb3","d3583e9eadcb6c192b59a071b45a6c50","d783b9dcb4376d31b10045db47344878","da5a1e43959814f3742c41eb36d58a65","da75317018c03633cafffe54c9b15b58","dc4b8f86d47f82fcc55088c9718f86c3","dd05c2e636249a0c5cd8ceb5f8737ed9","dffac01a3da670d3710b389cfbe8c258","e1664d77c3725d092869fb7dd71404d9","e23bfb5d683bf8ab968555f681c33686","e2ad6eca5d58083bcbac81073627de3d","e3ceb448f0ec773263e1f3f86c7a0ae2","e3da6f3071373f15ce45abc62e3f4659","e4312504f10da46b96340522d1130e89","e63ecf86ab5857ea8c9ce9b205584b37","e670c83f595f2a86480d5b7878215811","e70a46dee5370796c444bb0db0ee275d","e86239d3be4b4b3a5ac60bf0d2542f3e","e903984df5cb3a8a32a8bb6480f50380","ea2d269445ac95cddca106a4d2e521da","ea85ee75730a3c9fd6589254f40d43ed","eaf0b59dc1182325f5069f1f7ff7dc64","eb32bfe82446de991388f8b03be9da8f","f120a4bf322083dd3dce08919ce6aabe","f47dc56072a8e59d400558809f5c599f","f6af4af83f9bbef8a99d58f10361bcfb","f8fba2fbe847f2bda57f04fcca672819","fbb204a86a51c1f95666db9315d40dec","fc818ea8b04226f1050d735d4da311aa","fcc539703dc1f1ffe9820e47b18ddfcb","fd468dc4c5b56a303c0ca291c72d8057","ffb663148fd93f2796571e418c189ecf"};
	String[] EMPTY = {"150f3200ef17462afd8d600e68c5cdf3","2d5340c1cd5495d3a41de6c824707e37","40fca01118cfe4b1e433954e03c66c95","785a03e264e4cad06494cb828cea7308","ac49437b29b5472880c142477c93c340","d9bacab63f1fa3923b62283a68233c52","d9bae5e16c1e904a5efce06757f6100d","db3281188becfe1473667f5d25c83e96","e8c498e40b0ff9c8d58bdc8f29198722"};
	try {
		br = new BufferedReader(new FileReader(csvFile)); //Read csv as it is from input folder
		lr = new BufferedReader(new FileReader(csvFile));
		ArrayList<Double> sims_list = new ArrayList<Double>();
		String[] labels = new String[0];
		String[] updLabArray = new String[0];
		int[] commits = new int[0];
		int[] commitArray = new int[0];
		String[] sim = new String[0];
		String[] label = new String[1];
		int[] comit = new int[0];

		while ((line = br.readLine()) != null) 
		{
			sim = line.split(cvsSplitBy);
			label = new String [1];
			label[0] = sim[sim.length-1];
			comit = new int[1];
			comit[0] = Integer.parseInt(sim[0]);
			updLabArray = (String[])ArrayUtils.addAll(labels, label);
			labels = updLabArray;
			commitArray = ArrayUtils.addAll(commits, comit);
			commits = commitArray;
		}

		ArrayList<Integer> indx = new ArrayList<Integer>();
		for(int i=0; i<labels.length; ++i)
			{
			if(Arrays.asList(OVERGENERALIZED).contains(labels[i]) || Arrays.asList(EMPTY).contains(labels[i]) || Arrays.asList(SUCCESSFUL).contains(labels[i]))
			indx.add(i);
			}
		Integer[] OVERG_INDICES = (Integer[])indx.toArray(new Integer[indx.size()]);
		
		while((line1 = lr.readLine()) != null)
		{
			sim = line1.split(cvsSplitBy);//'this' row
			if(Arrays.asList(OVERGENERALIZED).contains(sim[sim.length-1]) || Arrays.asList(EMPTY).contains(sim[sim.length-1]) || Arrays.asList(SUCCESSFUL).contains(sim[sim.length-1]))
				{
				for (int i = 0; i < sim.length - 2; ++i)//ignore 1st and last columns
					{ 
					if(ArrayUtils.contains(OVERG_INDICES, i))//Pick corresponding cols
						{
						sims_list.add(Double.parseDouble(sim[i+1]));
						}	
					}
				}
			}

	Double[] sims = (Double[])sims_list.toArray(new Double[sims_list.size()]);
	double[] simArray = ArrayUtils.toPrimitive(sims);

	ArrayList<String> foo = new ArrayList<String>();
	ArrayList<Integer> bar = new ArrayList<Integer>();
	for(int i=0; i<labels.length; ++i)
		{
		if(Arrays.asList(OVERGENERALIZED).contains(labels[i]) || Arrays.asList(EMPTY).contains(labels[i]) || Arrays.asList(SUCCESSFUL).contains(labels[i])){
		foo.add(labels[i]);
		bar.add(commits[i]);}
		}
	String[] labelArray = foo.toArray(new String[foo.size()]);
	Integer[] commit = (Integer[])bar.toArray(new Integer[bar.size()]);

	String[] classAttr = new HashSet<String>(Arrays.asList(labelArray)).toArray(new String[0]);//Unique labels for class attribute

//	Predictions from Weka-- commits and corresponding class
       String fileWeka = "data/RECOMM_CSV/MOVE.csv";

       sr = new BufferedReader(new FileReader(fileWeka));
	String[] predicted_Grp = new String[0];
	String[] updLab = new String[0];
	int[] commit_ID = new int[0];
	int[] updCom = new int[0];
	String[] id = new String[0];

	while ((line2 = sr.readLine()) != null) 
	{
		id = line2.split(cvsSplitBy);
		String[] lab = new String[1];
		lab[0] = id[1];
		int[] com = new int[1];
		com[0] = Integer.parseInt(id[0]);
		updLab = (String[])ArrayUtils.addAll(predicted_Grp, lab);
		predicted_Grp = updLab;
		updCom = ArrayUtils.addAll(commit_ID, com);
		commit_ID = updCom;
	}

//	System.out.println(System.getProperty("user.dir"));
	System.out.println("PREDICTED_commits:	" + Arrays.toString(commit_ID));
	System.out.println("PREDICTED_Groups:	" + Arrays.toString(predicted_Grp));
/////////////////////////////////////////////////////
	File path = new File("/home/james/ExpertMiner/feb05pHEUR/feb05Disruptor1/recommendation");
	String[] files = path.list();
	Arrays.sort(files);

	for(int i=0; i<files.length; ++i) 
		System.out.println( i + "	:	" + files[i] );

	List<List<Integer>> commits_list = new ArrayList<>();

	for(int i = 0; i < files.length; ++i){
		List<Integer> lists = new ArrayList<>();
			for(int j = 0; j < labelArray.length; ++j){
				if(files[i].equals(labelArray[j])){
					lists.add(commit[j]);
				}
			}
		commits_list.add(lists);
	}	

	System.out.println("Commits corresponding to Initial classes ( LENGTH = " + commits_list.size() + " ):	" );
	System.out.println("=====================================================================================");
	System.out.println("");
	System.out.println(Arrays.toString(commits_list.toArray()));
	System.out.println("");

	List<Integer> toRemove = new ArrayList<>();

	//To compare groups after generalization 
	for(int j = 0; j < commits_list.size(); ++j){
		for(int i = 0; i < commit_ID.length; ++i){
			if((commits_list.get(j)).contains(commit_ID[i])){
				toRemove.add(commit_ID[i]);
				commits_list.get(Arrays.asList(files).indexOf(predicted_Grp[i])).add(commit_ID[i]);
			}
		}
	commits_list.get(j).removeAll(toRemove);
	}
	System.out.println("Commits corresponding to classes after MOVE operations ( LENGTH = " + commits_list.size() + " ):	" );
	System.out.println("=====================================================================================================");
	System.out.println("");
	System.out.println(Arrays.toString(commits_list.toArray()));

//////////////////////////	AFTER NEW GEN - predictions_AFTER.JAVA	TODO no need java.after
       List<List<Integer>> new_grps = new ArrayList<>();

       String fileCommits = "data/RECOMM_CSV/commitsGen.csv";
       String[] comms = new String[0];

       sr1 = new BufferedReader(new FileReader(fileCommits));
       while((line3 = sr1.readLine()) != null)
       		{
		comms = line3.split(cvsSplitBy);
		List<Integer> com_list = new ArrayList<>();
		for (int i = 0; i < comms.length ; ++i)
			{ 
				com_list.add(Integer.parseInt(comms[i]));	
			}
		new_grps.add(com_list);
		}

////////////////////////////////////////////////////

List<Integer> class_indx_1 = new ArrayList<>();// Group labels to correspond to commits_list
List<Integer> class_indx_0 = new ArrayList<>();

for(int i = 0; i < new_grps.size(); ++i){
	for(int j = 0; j < commits_list.size(); ++j){
		if(commits_list.get(j).containsAll(new_grps.get(i)) && new_grps.get(i).containsAll(commits_list.get(j))){
			class_indx_1.add(j);
			class_indx_0.add(i);
				}
			}
		}
System.out.println("");
System.out.println("");
System.out.println("New grps matching:	" + Arrays.toString(class_indx_0.toArray()));

System.out.println("");
System.out.println("");
System.out.println("New grp orig labels:	" + Arrays.toString(class_indx_1.toArray()));

// Move back for failed grps that were originally successful TODO evaluate.java + succCheck here, use above arrays -- Below not needed

int[] SUCC_BEFORE = new int[SUCCESSFUL.length];
int[] OVERG_BEFORE = new int[OVERGENERALIZED.length];
int[] EMPTY_BEFORE = new int[EMPTY.length];

for(int i = 0; i < SUCCESSFUL.length; ++i){
	SUCC_BEFORE[i] = Arrays.asList(files).indexOf(SUCCESSFUL[i]);
}

for(int i = 0; i < OVERGENERALIZED.length; ++i){
	OVERG_BEFORE[i] = Arrays.asList(files).indexOf(OVERGENERALIZED[i]);
}

for(int i = 0; i < EMPTY.length; ++i){
	EMPTY_BEFORE[i] = Arrays.asList(files).indexOf(EMPTY[i]);
}
// Read in three lines -- succ, overg, empty
       List<List<Integer>> new_n = new ArrayList<>();

       String fileStats = "data/RECOMM_CSV/statsGen.csv";
       String[] cstats = new String[0];

       sr2 = new BufferedReader(new FileReader(fileStats));
       while((line4 = sr2.readLine()) != null)
       		{
		cstats = line4.split(cvsSplitBy);
		List<Integer> stat_list = new ArrayList<>();
		for (int i = 0; i < cstats.length ; ++i)
			{ 
				stat_list.add(Integer.parseInt(cstats[i]));	
			}
		new_n.add(stat_list);
		}

//labeling below corresponds to sorted hashes of new groups
		Integer[] labels_gen = class_indx_0.toArray(new Integer[class_indx_0.size()]);
//Proper labels as used in original groups (based on commits belonging to these groups) 
		Integer[] labels_orig = class_indx_1.toArray(new Integer[class_indx_1.size()]);

		Integer[] OLD_SUCC_AFTER = new_n.get(0).toArray(new Integer[new_n.get(0).size()]);
		Integer[] OLD_OVERG_AFTER =  new_n.get(1).toArray(new Integer[new_n.get(1).size()]);
		Integer[] OLD_EMPTY_AFTER = new_n.get(2).toArray(new Integer[new_n.get(2).size()]);

		Integer[] SUCC_AFTER = new Integer[OLD_SUCC_AFTER.length];
		Integer[] OVERG_AFTER = new Integer[OLD_OVERG_AFTER.length];
		Integer[] EMPTY_AFTER = new Integer[OLD_EMPTY_AFTER.length];
//	Initialize with -1 since 0 is a class number, missing groups in orig take label -1 
		Arrays.fill(SUCC_AFTER, -1);
		Arrays.fill(OVERG_AFTER, -1);
		Arrays.fill(EMPTY_AFTER, -1);

	PrintWriter writeStats = new PrintWriter("data/RECOMM_CSV/new_groups.stats", "UTF-8");
		for(int i = 0; i < OLD_SUCC_AFTER.length; ++i){
			for(int j = 0; j < labels_gen.length; ++j){
				if(OLD_SUCC_AFTER[i]==labels_gen[j]){
					SUCC_AFTER[i] = labels_orig[j];
				}
			}
		}
		writeStats.println("SUCC after:	" + Arrays.toString(SUCC_AFTER));

		for(int i = 0; i < OLD_OVERG_AFTER.length; ++i){
			for(int j = 0; j < labels_gen.length; ++j){
				if(OLD_OVERG_AFTER[i]==labels_gen[j]){
					OVERG_AFTER[i] = labels_orig[j];
				}
			}
		}
		writeStats.println("");
		writeStats.println("");
		writeStats.println("OVERG after:	" + Arrays.toString(OVERG_AFTER));

		for(int i = 0; i < OLD_EMPTY_AFTER.length; ++i){
			for(int j = 0; j < labels_gen.length; ++j){
				if(OLD_EMPTY_AFTER[i]==labels_gen[j]){
					EMPTY_AFTER[i] = labels_orig[j];
				}
			}
		}
		writeStats.println("");
		writeStats.println("");
		writeStats.println("EMPTY after:	" + Arrays.toString(EMPTY_AFTER));
		writeStats.println("");
		writeStats.println("");	

//	Evaluation: Originally overgeneralized, now successful.
	List<Integer> New_SUCC = new ArrayList<>(Arrays.asList(SUCC_AFTER));
	List<Integer> New_OVERG = new ArrayList<>(Arrays.asList(OVERG_AFTER));
	List<Integer> New_EMPTY = new ArrayList<>(Arrays.asList(EMPTY_AFTER));

	New_OVERG.retainAll(New_SUCC);
	writeStats.println("OVERGEN GRPS THAT ARE NOW SUCCESSFUL:	" + Arrays.toString(New_OVERG.toArray()));

	writeStats.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


