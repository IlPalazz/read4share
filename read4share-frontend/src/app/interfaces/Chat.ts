export interface Chat {
  senderId: string;
  recipientId: string;
  message: string;
  timestamp: string;
  read: boolean;
}
