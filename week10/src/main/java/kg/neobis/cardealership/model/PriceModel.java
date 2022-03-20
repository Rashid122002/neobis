package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceModel {
    private int priceId;
    private double salePrice;

    public static PriceModel priceToPriceModel(Price price) {
        PriceModel priceModel = new PriceModel();
        priceModel.setPriceId(price.getPriceId());
        priceModel.setSalePrice(price.getSalePrice());
        return priceModel;
    }
}
