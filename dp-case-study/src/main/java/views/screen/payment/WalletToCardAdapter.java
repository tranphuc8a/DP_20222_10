package views.screen.payment;

import entity.payment.PaymentMethod;

public class WalletToCardAdapter extends CardPaymentScreenHandler{

        // You need to implement the interface your
        // client expects to use.
        WalletPaymentScreenHandler walletPaymentScreenHandler;
        public WalletToCardAdapter(WalletPaymentScreenHandler walletPaymentScreenHandler)
        {
            super();
            // we need reference to the object we
            // are adapting
            this.walletPaymentScreenHandler = walletPaymentScreenHandler;
        }

        protected PaymentMethod getPaymentMethod()
        {
            // translate the methods appropriately
            return walletPaymentScreenHandler.getWalletPaymentMethod();
        }

}
