package thank267.commons.models;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
@Document(collection = "properties")
@ToString
public class Property  {


	@Setter
    @Getter
	@BsonId
	@Id
    private ObjectId _id;

	@Getter
	@Setter
	// система контроля доступа
	private Boolean accessControl;

	@NonNull
	@Getter
	@Setter
	private Address address;

	@Getter
	@Setter
	// дополнительное оборудование и мебель
	private String additionalEquipmentAndFurniture;

	@Getter
	@Setter
	private String apartmentNumber;

	@Getter
	@Setter
	private Boolean arrest;

	@Getter
	@Setter
	private String attic;

	@Getter
	@Setter
	private String balcony;

	@Getter
	@Setter
	// решетки на окнах
	private Boolean barsOnWindows;

	@Getter
	@Setter
	private String base;

	@Getter
	@Setter
	private Boolean basement;

	@Getter
	@Setter
	// санузел
	private String bathroom;

	@Getter
	@Setter
	// Купить квартиру/комнату/дом
	private String buyPropetry;

	@NonNull
	@Getter
	@Setter
	private String category;

	@Getter
	@Setter
	// высота потолков
	private Dimension ceilingHeight;

	@Getter
	@Setter
	private String controlOfHouse;

	@Getter
	@Setter
	// кондиционер
	private Boolean conditioner;

	@Getter
	@Setter
	private String deposit;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private Dimension dimension;

	@Getter
	@Setter
	private String direction;

	@Getter
	@Setter
	private Integer distance;

	@Getter
	@Setter
	private String district;

	@Getter
	@Setter
	// Во время приватизации были учтены права несовершеннолетних
	private Boolean duringPrivatizationRightsTakenOfMinors;

	@Getter
	@Setter
	private Boolean electricity;

	@Getter
	@Setter
	//лифты
	private Elevators elevators;

	@Getter
	@Setter
	private Boolean encumbrance;

	@Getter
	@Setter
	private String entrance;

	@Getter
	@Setter
	private String fence;

	@Getter
	@Setter
	// стационарный телефон
	private Boolean fixedPhone;

	@Getter
	@Setter
	// этаж
	private Integer floor;

	@Getter
	@Setter
	// этажность
	private Integer floors;

	@Getter
	@Setter
	private String forest;

	@Getter
	@Setter
	// входная дверь
	private String frontDoor;

	@Getter
	@Setter
	private String gas;

	@NonNull
	@Getter
	@Setter
	private GeoJsonPoint geo;

	@Getter
	@Setter
	private String heating;

	@Getter
	@Setter
	private Integer hits;

	@BsonProperty("id")
	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private List<String> images;

	@Getter
	@Setter
	// интернет
	private String internet;


	@Getter
	@Setter
	private Integer isolatedRooms;

	@Getter
	@Setter
	private String landCategory;

	@Getter
	@Setter
	private String landIsDeveloped;

	@Getter
	@Setter
	private Float landSquare;

	@Getter
	@Setter
	private Float liveSquare;

	@Getter
	@Setter
	private Float kitchen;

	@Getter
	@Setter
	// кухонная плита
	private String kitchenStove;

	@NonNull
	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	// количество зарегистрированных
	private Integer numberOfRegistered;

	@Getter
	@Setter
	// капитальный ремонт
	private Boolean overhaul;

	@Getter
	@Setter
	// перекрытия
	private String overlaps;

	@Getter
	@Setter
	private String outbuilding;

	@Getter
	@Setter
	// парковка
	private String parking;

	@Getter
	@Setter
	private String partition;

	@Getter
	@Setter
	private String permittedUse;

	@Getter
	@Setter
	private String pipeline;

	@Getter
	@Setter
	// наличие собственников несовершеннолетних
	private Boolean presencOfOwnersOfMinors;

	@Getter
	@Setter
	// Наличие родственников ранее зарегистрированных находящихся в армии, местах лишения свободы и т.д.
	private Boolean presencePreviouslyRegisteredInArmySoForth;

	@Getter
	@Setter
	private Price price;

	@Getter
	@Setter
	private String readyToMoveIn;

	@Getter
	@Setter
	// перепланировка есть/нет согласована/несогласована
	private String replanning;

	@Getter
	@Setter
	private String reservoir;

	@Getter
	@Setter
	private String rightToLand;

	@Getter
	@Setter
	private Rieltor rieltor;

	@Getter
	@Setter
	private String road;

	@Getter
	@Setter
	private String roofing;

	@Getter
	@Setter
	private Integer rooms;

	@Getter
	@Setter
	private Integer roomsSales;

	@Getter
	@Setter
	// продажа квартиры/комнаты/дома
	private String salePropetry;

	@Getter
	@Setter
	private String sanitation;

	@Getter
	@Setter
	private Boolean sauna;

	@Getter
	@Setter
	// сигнализация
	private Boolean signaling;

	@Getter
	@Setter
	private Boolean security;

	@Getter
	@Setter
	private Boolean swimmingPool;

	@Getter
	@Setter
	private Float square;

	@Getter
	@Setter
	private String squareUnit;

	@Getter
	@Setter
	// время последнего ремонта
	private String timeOfLastRepair;

	@Getter
	@Setter
	// способ управления многоквартирным домом
	private String typeOfManagementBuiding;

	@NonNull
	@Getter
	@Setter
	private String type;

	@Getter
	@Setter
	private String typeExplainNom;

	@Getter
	@Setter
	private String typeExplainGen;

	@Getter
	@Setter
	private String typeExplainAcc;

	@Getter
	@Setter
	private String typePlans;

	@Getter
	@Setter
	private String utilities;

	@Getter
	@Setter
	// размер коммунальных платежей
	private UtilitiesPrice utilitiesPrice;

	@Getter
	@Setter
	private Boolean veranda;

	@Getter
	@Setter
	// видеонаблюдение
	private Boolean videoObservation;

	@Getter
	@Setter
	// материал стен
	private String wall;

	@Getter
	@Setter
	private String waterSupply;

	@Getter
	@Setter
	// окна
	private String windows;

	@Getter
	@Setter
	private Boolean winterGarden;

	@Getter
	@Setter
	// окна выходят
	private WindowsOverlook windowsOverlook;

	@Getter
	@Setter
	// двор
	private String yard;

	@Getter
	@Setter
	// год постройки
	private String yearBuild;

    public Optional<String> getFirstImage() {

		List<String> images = getImages();

    	if (images!=null && images.size()>0) {

    		return Optional.ofNullable(images.get(0));
   		}
    	else
    		return Optional.empty();

	}

	public String getRieltorPhone() {

		return getRieltor().getPhone();

	}

    public String getRieltorName() {

		return getRieltor().getName();

	}

	public String getFormattedDescription() {

		return "<div class=\"property-description\">"+getDescription().replaceAll("(\r\n|\n)", "<br />")+"</div>";

	}

    public Integer getRieltorId() {

		return getRieltor().getId();

	}

    public Double getLat() {
		return getGeo().getCoordinates().get(1);
	}

	public Double getLon() {
		return getGeo().getCoordinates().get(0);
	}

	public Set<String> getCommonTags() {

		Set<String> tags = new LinkedHashSet<>();

		tags.add("Недвижимость");

		tags.add("Жилье");

		tags.add("Дом");

		if (getDescription().toLowerCase().indexOf("ипоте") >= 0) {
			tags.add("Ипотека");
			tags.add("Сбербанк");
			tags.add("ВТБ");

		}

		tags.add(getBuyPropetry());

		tags.add(getSalePropetry());

		tags.add(getAddress().getCity());

		Optional.ofNullable(getDistrict()).ifPresent(district -> tags.add(district));

		tags.add(getAddress().getStreet());

		return tags;

	}

}
