###Photos, PHPhotoLibrary

//ViewController

```swift
var fetchResult: PHFetchResult<PHAsset>! //가져오기 메서드에서 반환 된 에셋/컬렉션 목록
//에셋: 이미지, 비디오, 라이브 포토
//컬렉션: 앨범, 특별한 순간 등: 에셋의 묶음
let imageManager: PHCachingImageManager = PHCachingImageManager() //많은 에셋을 일괄적으로 로딩하기 위한 방법을 제공
```

```swift
func requestCollection() {
        let cameraRoll: PHFetchResult<PHAssetCollection> = PHAssetCollection.fetchAssetCollections(with: .smartAlbum, subtype: .smartAlbumUserLibrary, options: nil)
        //PHAssetCollection 클래스의 가져오기 메서드
        //with type, subtype: 에셋 컬렉션의 타입
        //options: nil(기본값) or 정렬 순서, 필터 등

        //가져오기 결과인 에셋 컬렉션
        guard let cameraRollCollection = cameraRoll.firstObject else{
            return
        }

        //생성일자를 기준으로 한 정렬 옵션 셋팅
        let fetchOptions:PHFetchOptions = {
            let Options: PHFetchOptions = PHFetchOptions()
            Options.sortDescriptors = [NSSortDescriptor(key: "creationDate", ascending: false)]
            return Options
        }()

        //PHAsset 객체 타입의  PHFetchResult 클래스
        //PHAsset 클래스의 가져오기 메서드 이용, cameraRollCollection에 할당된 에셋 컬렉션에서 에셋을 가져와 fetchResult에 할당
        fetchResult = PHAsset.fetchAssets(in: cameraRollCollection, options: fetchOptions)
    }
```

```swift
override func viewDidLoad() {
        super.viewDidLoad()

        //접근 권한에 대한 정보를 반환하는 메서드
        let photoAuthorizationStatus = PHPhotoLibrary.authorizationStatus()
}
```

```swift
///fetchResult.object(at index) 메서드로 접근
 let asset: PHAsset = fetchResult.object(at: indexPath.row)
```

```swift
//특정 에셋에 대한 이미지를 표현하여 반환
//마지막 block => 이미지 로딩이 끝난 이후 호출 될 콜백 함수를 작성(resultHandler)
imageManager.requestImage(for: asset, targetSize: CGSize(width: 30, height: 30), contentMode: .aspectFill, options: nil) { image, _ in cell.imageView?.image = image
    }
```

```swift
///에셋을 삭제하는
func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete{
            let asset: PHAsset = self.fetchResult[indexPath.row]

            //PhotoLibrary에 변화를 요청
            //PHassetChangeRequest 클래스의 에셋 삭제 메서드를 호출
            PHPhotoLibrary.shared().performChanges({
                PHAssetChangeRequest.deleteAssets([asset] as NSArray)}
                                                   , completionHandler: nil)
        }
    }

    //PHPhotoLibraryChangeObserver 프로토콜의 메서드
    //포토 라이브러리가 변화하면 호출됨
    func photoLibraryDidChange(_ changeInstance: PHChange) {
        guard let changes = changeInstance.changeDetails(for: fetchResult) else{
            return
        }

        //fetchResultAfterChanges: PHFetchResult<ObjectType>, 현재의 fetch 결과
        fetchResult = changes.fetchResultAfterChanges
        OperationQueue.main.addOperation {
            self.tableView.reloadSections(IndexSet(0...0), with: .automatic)
        }
    }
```

///ImageZoomViewController

```swift
//UIScrollViewDelegate 프로토콜의 메서드, 스크롤뷰가 zoom할 view를 리턴
 func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return self.imageView
    }
```
